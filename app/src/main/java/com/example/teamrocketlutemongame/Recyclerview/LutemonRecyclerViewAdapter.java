package com.example.teamrocketlutemongame.Recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.R;

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

    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }



    public void refresh(ArrayList<Lutemon> lutemons){
        this.lutemons = lutemons;
    }
}
