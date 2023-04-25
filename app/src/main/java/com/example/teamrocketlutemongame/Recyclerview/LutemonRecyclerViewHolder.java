package com.example.teamrocketlutemongame.Recyclerview;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamrocketlutemongame.R;

public class LutemonRecyclerViewHolder extends RecyclerView.ViewHolder {
    protected TextView lutemonName,hp,atk,def,special,wins,deaths;
    protected ImageView lutemonImg;


    public LutemonRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonName = itemView.findViewById(R.id.txtrvLutemonName);
        hp = itemView.findViewById(R.id.txtrvLutemonHP);
        atk = itemView.findViewById(R.id.txtrvLutemonATK);
        def = itemView.findViewById(R.id.txtrvLutemonDEF);
        special = itemView.findViewById(R.id.txtrvLutemonSpecial);
        lutemonImg = itemView.findViewById(R.id.imgrvImage);
        wins = itemView.findViewById(R.id.txtrvLutemonWins);
        deaths = itemView.findViewById(R.id.txtrvLutemonLosses);

    }
}
