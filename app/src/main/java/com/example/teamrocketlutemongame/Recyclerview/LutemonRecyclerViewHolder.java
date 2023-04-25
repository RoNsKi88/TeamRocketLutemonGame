package com.example.teamrocketlutemongame.Recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamrocketlutemongame.R;

public class LutemonRecyclerViewHolder extends RecyclerView.ViewHolder {
    protected TextView lutemonName,hp,atk,def,special,wins,deaths,lvl;
    protected ImageView lutemonImg;
    protected ConstraintLayout lutemonFrame;
    protected CheckBox hcStatus;


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
        lutemonFrame = itemView.findViewById(R.id.lutemonFrame);
        hcStatus = itemView.findViewById(R.id.checkBoxrvHardcore);
        lvl = itemView.findViewById(R.id.txtrvLutemonLVL);


    }
}
