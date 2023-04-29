package com.example.teamrocketlutemongame.Lutemons;

import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.R;
import com.example.teamrocketlutemongame.Stats;

public class Pixeli extends Lutemon{

    public Pixeli (String name, boolean hc) {
        // name attack defence health imageFront imageBack hcStatus
        super(name,hc);
        attack = 30;
        defence = 30;
        maxHealth = 100;
        health = maxHealth;
        imgFront = R.drawable.pixel_back;
        imgBack = R.drawable.pixel_back;
        special = "Spiky";
        color = "Pixeli";
    }

}
