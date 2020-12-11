package org.polinema.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import org.polinema.retrofit.databinding.ActivityMainBinding;
import org.polinema.retrofit.models.Repo;
import org.polinema.retrofit.services.GithubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //interface class
        GithubService service = retrofit.create(GithubService.class);

        Call<List<Repo>> repos = service.listRepos("PanduDLaksono");

        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> repoList) {
                binding.setRepo(repoList.body().get(2));
            }
            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }
}