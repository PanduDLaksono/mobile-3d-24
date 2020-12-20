package org.dotapedia.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.robertlevonyan.views.chip.Chip;
import com.robertlevonyan.views.chip.OnChipClickListener;

import org.dotapedia.R;
import org.dotapedia.Services.IItemClickListener;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HeroRoleAdapter extends RecyclerView.Adapter<HeroRoleAdapter.MyViewHolder> {

    Context context;
    List<String> roleList;

    public HeroRoleAdapter(Context context, List<String> roleList) {
        this.context = context;
        this.roleList = roleList;
    }


    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder( @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.chip_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.chip.setChipText(roleList.get(position));
        holder.setiItemClickListener(new IItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                //Fix crash
            }
        });

    }

    @Override
    public int getItemCount() {
        return roleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        Chip chip;

        IItemClickListener iItemClickListener;

        public void setiItemClickListener(IItemClickListener iItemClickListener) {
            this.iItemClickListener = iItemClickListener;
        }

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            chip = (Chip) itemView.findViewById(R.id.chip);
            chip.setOnChipClickListener(new OnChipClickListener() {
                @Override
                public void onChipClick(View v) {
                    iItemClickListener.onClick(v,getAdapterPosition());
                }
            });
        }
    }
}
