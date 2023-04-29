package com.example.teamrocketlutemongame.Lutemons;

import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.R;
import com.example.teamrocketlutemongame.Stats;

public class Pixeli extends Lutemon{
    public Pixeli(String name, boolean hc) {
        // name attack defence health imageFront imageBack hcStatus
        super(name,10,10,10, R.drawable.player_image,R.drawable.player_image,hc);









    }

    public int makeAttack(){
        double damage = Math.random() * attack + 1;


        return 123;
    }
}
