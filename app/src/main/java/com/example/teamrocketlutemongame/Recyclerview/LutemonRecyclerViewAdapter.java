package com.example.teamrocketlutemongame.Recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamrocketlutemongame.Fragments.CollectionFragment;
import com.example.teamrocketlutemongame.Fragments.MenuFragment;
import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.R;
import com.example.teamrocketlutemongame.Storage;

import java.util.ArrayList;


public class LutemonRecyclerViewAdapter extends RecyclerView.Adapter<LutemonRecyclerViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons;

    public LutemonRecyclerViewAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }


    @NonNull
    @Override
    public LutemonRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemons_recycler_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonRecyclerViewHolder holder, int position) {
        int pos = holder.getAdapterPosition();
        Lutemon lutemon = lutemons.get(pos);
        holder.lutemonImg.setImageResource(lutemon.getImgFront());
        holder.lutemonName.setText(lutemon.getName());
        holder.hp.setText(String.valueOf(lutemon.getMaxHP()));
        holder.atk.setText(String.valueOf(lutemon.getAtk()));
        holder.def.setText(String.valueOf(lutemon.getDef()));
        holder.special.setText(lutemon.getSpecial());
        holder.wins.setText(String.valueOf(lutemon.getWins()));
        holder.deaths.setText(String.valueOf(lutemon.getLosses()));
        holder.lvl.setText(String.valueOf(lutemon.getLevel()));
        if (lutemon.getHcStatus() == true){
            holder.hcStatus.setChecked(true);
        }

        holder.lutemonFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Storage storage = Storage.getInstance();

                Storage.getInstance().getLutemons().add(Storage.getInstance().getPlayer().getPlayerLutemon());

                storage.getPlayer().setPlayerLutemon(storage.getLutemon(pos));
                storage.removeLutemon(pos);
                notifyDataSetChanged();
                CollectionFragment.refresh();
                MenuFragment.refresh();

            }
        });


    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }



    public void refresh(ArrayList<Lutemon> lutemons){
        this.lutemons = lutemons;
    }
}
