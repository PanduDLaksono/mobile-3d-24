package org.dotapedia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.dotapedia.Adapters.HeroListAdapter;
import org.dotapedia.Models.MHero;
import org.dotapedia.Services.IHero;
import org.dotapedia.Services.RetrofitClient;
import org.dotapedia.Utils.Common;
import org.dotapedia.Utils.ItemOffsetDecoration;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class HeroList extends Fragment {

    IHero iHero;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    RecyclerView hero_list_recyclerview;

    static HeroList instance;

    public static HeroList getInstance(){
        if (instance == null)
            instance = new HeroList();
        return instance;
    }

    public HeroList() {
        Retrofit retrofit = RetrofitClient.getInstance();
        iHero = retrofit.create(IHero.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hero_list, container, false);

        hero_list_recyclerview = (RecyclerView) view.findViewById(R.id.hero_list_recyclerview);
        hero_list_recyclerview.setHasFixedSize(true);
        hero_list_recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        ItemOffsetDecoration itemOffsetDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.spacing);
        hero_list_recyclerview.addItemDecoration(itemOffsetDecoration);
        
        fetchData();

        return view;
    }

    private void fetchData() {
        compositeDisposable.add(iHero.getListHero()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MHero>() {
                    @Override
                    public void accept(MHero mHero) throws Exception {
                        Common.commonHeroList = mHero.getHero();
                        HeroListAdapter adapter = new HeroListAdapter(getActivity(), Common.commonHeroList);

                        hero_list_recyclerview.setAdapter(adapter);
                    }
                })
        );
    }
}