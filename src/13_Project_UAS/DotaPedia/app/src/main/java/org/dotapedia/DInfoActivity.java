package org.dotapedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import org.dotapedia.databinding.ActivityDinfoBinding;

public class DInfoActivity extends AppCompatActivity {

//    private TextView tv_nama, tv_nim, tv_kelas, tv_github;

    private ActivityDinfoBinding activityDinfoBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinfo);

//        tv_nama = (TextView) findViewById(R.id.nama);
//        tv_nim = (TextView) findViewById(R.id.nim);
//        tv_kelas = (TextView) findViewById(R.id.kelas);
//        tv_github = (TextView) findViewById(R.id.github);

        activityDinfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_dinfo);
        activityDinfoBinding.setInfo(getCurrentInfo());



    }

    private Info getCurrentInfo(){
        Info info = new Info();
        info.setNama("Pandu Dwi Laksono");
        info.setNIM("1941723006");
        info.setKelas("TI-3D");
        info.setGithub("https://www.github.com/PanduDLaksono");
        return info;
    }
}