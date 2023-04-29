package com.example.teamrocketlutemongame.Lutemons;

import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.R;

public class Green extends Lutemon {

    public Green (String name, boolean hc) {
        // name attack defence health imageFront imageBack hcStatus
        super(name,hc);
        attack = 10;
        defence = 0;
        maxHealth = 40;
        health = maxHealth;
        imgFront = R.drawable.green_front;
        imgBack = R.drawable.green_back;
        special = "IgnoreDmg";
        color = "Green";
    }
}
