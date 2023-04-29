package com.example.teamrocketlutemongame.Lutemons;

import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.R;

public class Orange extends Lutemon {
    public Orange (String name, boolean hc) {

        super(name,hc);
        attack = 15;
        defence = 0;
        maxHealth = 30;
        health = maxHealth;
        imgFront = R.drawable.orange_front;
        imgBack = R.drawable.orange_back;
        special = "ExtCritChan";

    }
}
