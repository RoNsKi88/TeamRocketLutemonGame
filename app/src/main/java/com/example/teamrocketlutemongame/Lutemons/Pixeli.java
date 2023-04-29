package com.example.teamrocketlutemongame.Lutemons;

import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.R;


public class Pixeli extends Lutemon{

    public Pixeli (String name, boolean hc) {

        super(name,hc);
        attack = 30;
        defence = 30;
        maxHealth = 100;
        health = maxHealth;
        imgFront = R.drawable.pixel_back;
        imgBack = R.drawable.pixel_back;
        special = "Spiky";

    }


    public int defend(int attack){
        double randomNumber = Math.random();
        double dodgeChange = 0.02;

        if (randomNumber < dodgeChange) {               //Dodge change
            attack = 0;
        }
        double defenceRoll = defence * Math.random();   // rolls defence 0 to lutemons defence.
        double damage = attack - defenceRoll; //Counts final damage after defending agaist attack
        if (damage < 0){    // Condition for defence roll that lutemon won't get hp from enemy attack.
            damage = 0;
        }
        damage /= 2; //Pixels special. takes only half damage.

        health -= (int)damage;
        return (int) damage;
    }
}
