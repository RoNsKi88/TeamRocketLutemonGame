package com.example.teamrocketlutemongame.Recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.R;
import com.example.teamrocketlutemongame.Storage;

public class PlayerLutemonAdapter extends RecyclerView.Adapter<LutemonRecyclerViewHolder>  {
    private Context context;
    private Lutemon lutemon;

    public PlayerLutemonAdapter(Context context, Lutemon lutemon) {
        this.context = context;
        this.lutemon = lutemon;
    }


    @NonNull
    @Override
    public LutemonRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemons_recycler_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonRecyclerViewHolder holder, int position) {

        holder.lutemonImg.setImageResource(lutemon.getImgFront());
        holder.lutemonName.setText(lutemon.getName());
        holder.hp.setText(String.valueOf(lutemon.getMaxHP()));
        holder.atk.setText(String.valueOf(lutemon.getAtk()));
        holder.def.setText(String.valueOf(lutemon.getDef()));
        holder.special.setText(lutemon.getSpecial());
        holder.wins.setText(String.valueOf(lutemon.getWins()));
        holder.deaths.setText(String.valueOf(lutemon.getLosses()));
        holder.lvl.setText(String.valueOf(lutemon.getLevel()));
        if (Storage.getInstance().getPlayer().getPlayerLutemon().getHcStatus()==true){
            holder.hcStatus.setChecked(true);
        }

    }

    @Override
    public int getItemCount() {
        return 1;

    }
}
