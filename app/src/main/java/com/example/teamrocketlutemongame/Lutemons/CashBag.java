package com.example.teamrocketlutemongame.Lutemons;

import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.R;

public class CashBag extends Lutemon {
    public CashBag(String name, boolean hc) {

        super(name, hc);
        attack = 1;
        defence = 0;
        maxHealth = 60;
        health = maxHealth;
        imgFront = R.drawable.cash_bag;
        imgBack = R.drawable.cash_bag;
        special = "Nothing";

    }

    public void boost(int boost) {  // boosts cashbags maxhealth levels for given amount

        for (int i = 0; i < boost; i++) {
            level += 1;
            for (int j = 0; j < level; j++) {
                maxHealth += 2;
            }

        }
    }
}
