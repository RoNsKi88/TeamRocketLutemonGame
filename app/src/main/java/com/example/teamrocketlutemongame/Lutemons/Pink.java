package com.example.teamrocketlutemongame.Lutemons;

import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.R;

public class Pink extends Lutemon {

    public Pink (String name, boolean hc) {

        super(name,hc);
        attack = 10;
        defence = 5;
        maxHealth = 30;
        health = maxHealth;
        imgFront = R.drawable.pink_front;
        imgBack = R.drawable.pink_back;
        special = "Leech";

    }


}
