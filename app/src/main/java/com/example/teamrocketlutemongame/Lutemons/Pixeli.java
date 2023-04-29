package com.example.teamrocketlutemongame.Lutemons;

import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.R;
import com.example.teamrocketlutemongame.Stats;

public class Pixeli extends Lutemon{

    public Pixeli (String name, boolean hc) {
        // name attack defence health imageFront imageBack hcStatus
        super(name,hc);
        attack = 10;
        defence = 10;
        maxHealth = 40;
        health = maxHealth;
        imgFront = R.drawable.player_image;
        imgBack = R.drawable.player_image;
        special = "Spiky";
        color = "Pixeli";
    }
    public int makeAttack(){
        double damage = Math.random() * attack + 1;


        return 123;
    }
}
