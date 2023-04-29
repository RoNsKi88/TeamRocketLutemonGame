package com.example.teamrocketlutemongame;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.example.teamrocketlutemongame.Lutemons.CashBag;
import com.example.teamrocketlutemongame.Lutemons.Gray;
import com.example.teamrocketlutemongame.Lutemons.Green;
import com.example.teamrocketlutemongame.Lutemons.Orange;
import com.example.teamrocketlutemongame.Lutemons.Pixeli;
import com.example.teamrocketlutemongame.Lutemons.Rainbow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lutemon extends Specs implements Serializable {
    public static final ArrayList<String> colors = new ArrayList<>(Arrays.asList("Gray","Green","Orange","Pink","Rainbow", "Pixeli"));
    protected static final ArrayList<String> enemyNames = new ArrayList<>(Arrays.asList("SpagettiRyhmä","Työtön","NuoriOsuja","Koodari","LutesinJäsen","Ruotsintentti","Matematiikantentti","Teppo Tarkka-ampuja","Mr Vac"));
    protected static final ArrayList<String> randomLutemonNames = new ArrayList<>(Arrays.asList("Jorma","Kaaleppi","Reiska","PatonkiAnneli","RoNsKi","Keijo","ErittäinKovaKivi!","KovinKivi","KumiTarzan"));
    protected int attack = 10,defence = 10,maxHealth = 10,health = maxHealth,level = 1,experience,imgFront,imgBack;
    protected double lvlUp = 1.2;
    protected String special;
    private static int id = 0;
    protected boolean hardcore;
    protected String color;

    public Lutemon(String name,boolean hc){
        id = id++;
        if (name.isEmpty()){
            Random random = new Random();
            name = Lutemon.randomLutemonNames.get(random.nextInt(Lutemon.randomLutemonNames.size()));
        }
        this.name = name;
        this.hardcore = hc;

    }
    public void boost(int boost){
        for (int i=0;i<boost;i++){
            levelUp();

        }
    }

    public boolean addXP(double points){
        experience += points;
        boolean condition = false;
        if (experience > lvlUp){
            condition = true;
            levelUp();
            experience = 0;
        }
        return condition;
    }
    protected void levelUp(){
        int j;

        level += 1;
        lvlUp *= 1.4;
        for (int i = 0;i < level;i++){  // lutemon gets bonus attributes eguals to its own level
            j = (int)(Math.random()*3);
            switch (j){
                case 0:
                    attack += 1;
                    //System.out.println("Lvl up, you gain +1 att");
                    break;
                case 1:
                    defence += 1;
                    //System.out.println("Lvl up, you gain +1 def");
                    break;
                case 2:
                    maxHealth += 2;
                    //System.out.println("Lvl up, you gain +2 hp");
                    break;
            }
        }
    }
    public int makeAttack(){
        double damage = Math.random() * attack + 1;

        if (this instanceof Rainbow){   // Rainbos's special. Rolls two times attack roll and bigger is counted.
            System.out.println("tämä on testi");
            double extraRollDamage = Math.random() * attack + 1;
            if(extraRollDamage > damage){
                damage = extraRollDamage;
            }
        }
        double randomNumber = Math.random();
        double criticalHitChange;
        if (this instanceof Orange){    // Oranges special critical hit change is double.
            criticalHitChange = 0.2;
        }else {
            criticalHitChange = 0.1;
        }

        if (randomNumber < criticalHitChange){    //Critical hit change.
            System.out.println("Critical hit!");
            damage = damage * 2;
        }
        System.out.println("Damage number: "+ (int)damage);
        return (int) damage;
    }
    public int defend(int attack){
        double randomNumber = Math.random();
        double defendChance = 0.02;
        if (this instanceof Green){ //green has bigger change to ignore all damage.
            defendChance = 0.1;
        }
        if (randomNumber < defendChance) {                                  //Dodge change
            attack = 0;
        }
        double extraDefence = 0;
        double defenceRoll = defence * Math.random();
        if (this instanceof Gray){  // grey gets 2 rolls for defence. only bigger roll is counted.
            extraDefence = defence * Math.random();
            if (extraDefence > defenceRoll){
                defenceRoll = extraDefence;
            }
        }
        double damage = attack - defenceRoll; //Counts final damage after defending agaist attack
        if (damage < 0){
            damage = 0;
        }

        health -= (int)damage;
        return (int) damage;
    }

    public int getLevel(){
        return level;
    }
    public String getColor(){
        return color;
    }
    public int getHP(){
        return health;
    }
    public void setHP(int amount){
        health += amount;   // For pink lutemons leech ability. IT CAN GET HP OVER IT'S MAX HP
    }
    public int getMaxHP(){
        return maxHealth;
    }
    public void resetHP(){
        health = maxHealth;
    }
    public int getAtk(){
        return attack;
    }
    public int getDef(){
        return defence;
    }
    public String getSpecial(){
        return special;
    }
    public int getImgFront(){
        return imgFront;
    }
    public Boolean getHcStatus(){
        return hardcore;
    }

}
