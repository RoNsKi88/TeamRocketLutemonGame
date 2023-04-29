package com.example.teamrocketlutemongame.Lutemons;

import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.R;

public class Gray extends Lutemon {

    public Gray(String name, boolean hc) {
        // name attack defence health imageFront imageBack hcStatus
        super(name,hc);
        attack = 10;
        defence = 10;
        maxHealth = 20;
        health = maxHealth;
        imgFront = R.drawable.gray_front;
        imgBack = R.drawable.gray_back;
        special = "ExtDefRol";
    }

}
