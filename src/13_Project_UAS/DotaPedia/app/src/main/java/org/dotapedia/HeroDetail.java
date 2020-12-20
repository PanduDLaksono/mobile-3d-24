package org.dotapedia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.dotapedia.Adapters.HeroRoleAdapter;
import org.dotapedia.Models.Hero;
import org.dotapedia.Utils.Common;

public class HeroDetail extends Fragment {

    ImageView hero_img;
    TextView hero_name, hero_att, hero_tipe, hero_leg, hero_lore;
    RecyclerView recycler_role;

    static HeroDetail instance;

    public static HeroDetail getInstance() {
        if (instance == null)
            instance = new HeroDetail();
        return instance;
    }

    public HeroDetail() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_hero_detail, container, false);



        Hero hero;

        //get position from argument
        if (getArguments().get("id") == null)
            hero = Common.commonHeroList.get(getArguments().getInt("position"));
        else
            hero = null;

        hero_img = (ImageView) itemView.findViewById(R.id.hero_image);
        hero_name = (TextView) itemView.findViewById(R.id.name_hero);
        hero_att = (TextView) itemView.findViewById(R.id.name_tipe);
        hero_tipe = (TextView) itemView.findViewById(R.id.jenis_attack);
        hero_leg = (TextView) itemView.findViewById(R.id.jumlah_kaki);
        hero_lore = (TextView) itemView.findViewById(R.id.lore);

        recycler_role = (RecyclerView) itemView.findViewById(R.id.recycler_role);
        recycler_role.setHasFixedSize(true);
        recycler_role.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        setDetailHero(hero);

        return itemView;
    }

    private void setDetailHero(Hero hero) {
        //load image
        Glide.with(getActivity()).load(hero.getImg()).into(hero_img);

        hero_name.setText(hero.getLocalized_name());
        hero_att.setText(hero.getPrimary_attr());
        hero_tipe.setText(hero.getAttack_type());
        hero_leg.setText(hero.getLegs());
        hero_lore.setText(hero.getLore());

        //set role
        HeroRoleAdapter roleAdapter = new HeroRoleAdapter(getActivity(), hero.getRoles());
        recycler_role.setAdapter(roleAdapter);
    }


}