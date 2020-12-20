package org.dotapedia.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.dotapedia.Models.Hero;
import org.dotapedia.R;
import org.dotapedia.Services.IItemClickListener;
import org.dotapedia.Utils.Common;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class  HeroListAdapter extends RecyclerView.Adapter<HeroListAdapter.MyViewHolder> {

    Context context;
    List<Hero> HeroList;

    public HeroListAdapter(Context context, List<Hero> mHeroList) {
        this.context = context;
        this.HeroList = mHeroList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.hero_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //load image
        Glide.with(context).load(HeroList.get(position).getImg()).into(holder.hero_img);

        //set name
        holder.hero_txt.setText(HeroList.get(position).getLocalized_name());

        //Event
        holder.setiItemClickListener(new IItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                LocalBroadcastManager.getInstance(context)
                        .sendBroadcast(new Intent(Common.KEY_ENABLE_HOME).putExtra("position" , position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return HeroList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView hero_img;
        TextView hero_txt;

        IItemClickListener iItemClickListener;

        public void setiItemClickListener(IItemClickListener iItemClickListener) {
            this.iItemClickListener = iItemClickListener;
        }

        public MyViewHolder(View itemView) {
            super(itemView);

            hero_img = (ImageView) itemView.findViewById(R.id.hero_image);
            hero_txt = (TextView) itemView.findViewById(R.id.txt_hero_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            iItemClickListener.onClick(view, getAdapterPosition());
        }
    }
}
