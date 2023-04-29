package com.example.teamrocketlutemongame.Lutemons;

import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.R;

public class Rainbow extends Lutemon {
    public Rainbow (String name, boolean hc) {
        // name attack defence health imageFront imageBack hcStatus
        super(name,hc);
        attack = 20;
        defence = -10;
        maxHealth = 40;
        health = maxHealth;
        imgFront = R.drawable.rain_front;
        imgBack = R.drawable.rain_back;
        special = "ExtAttRol";
        color = "Rainbow";
    }
}
