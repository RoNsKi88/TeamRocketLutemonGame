package com.example.teamrocketlutemongame.Lutemons;

import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.R;

public class CashBag extends Lutemon{
    public CashBag(String name, boolean hc) {
        // name attack defence health imageFront imageBack hcStatus
        super(name,hc);
        attack = 1;
        defence = 0;
        maxHealth = 60;
        health = maxHealth;
        imgFront = R.drawable.cash_bag;
        imgBack = R.drawable.cash_bag;
        special = "Nothing";
        color = "Cashbag";
    }

}
