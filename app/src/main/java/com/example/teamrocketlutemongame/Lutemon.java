package com.example.teamrocketlutemongame;

import android.widget.ImageView;

import com.example.teamrocketlutemongame.Lutemons.Pixeli;
import com.example.teamrocketlutemongame.Lutemons.Rainbow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lutemon extends Specs implements Serializable {
    private final ArrayList<String> colors = new ArrayList<>(Arrays.asList("Gray","Green","Orange","Pink","Rainbow"));
    protected static final ArrayList<String> enemyNames = new ArrayList<>(Arrays.asList("SpagettiRyhmä","Työtön","NuoriOsuja","Koodari","LutesinJäsen","Ruotsintentti","Matematiikantentti","Teppo Tarkka-ampuja","Mr Vac"));
    protected static final ArrayList<String> randomLutemonNames = new ArrayList<>(Arrays.asList("Jorma","Kaaleppi","Reiska","PatonkiAnneli","RoNsKi","Keijo","ErittäinKovaKivi!","KovinKivi","KumiTarzan"));
    protected int attack = 10,defence = 10,maxHealth = 10,health = maxHealth,level = 0,experience,imgFront,imgBack;
    private double lvlUp = 1.2;
    protected String special;
    private static int id = 0;
    protected boolean hardcore;
    private String color;

    public Lutemon(String name,boolean hc){
        id = id++;
        if (name.isEmpty()){
            Random random = new Random();
            name = Lutemon.randomLutemonNames.get(random.nextInt(Lutemon.randomLutemonNames.size()));
        }
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.imgFront = imgFront;
        this.imgBack = imgBack;
        this.hardcore = hc;
        this.special = special;

    }
    public void boost(int boost){
        for (int i=0;i<boost;i++){
            levelUp();
        }
    }

    public void addXP(int points){
        experience += points;

        if (experience > lvlUp){
            levelUp();
            level += 1;
            experience = 0;
        }
    }
    protected void levelUp(){
        int j;
        lvlUp *= 1.2;
        for (int i = 0;i < level;i++){
            j = (int)(Math.random()*3);
            switch (j){
                case 0:
                    attack += 1;
                    break;
                case 1:
                    defence += 1;
                    break;
                case 2:
                    maxHealth += 2;
                    break;
            }
        }
    }
    public int makeAttack(){
        double damage = Math.random() * attack + 1;
        if (this instanceof Pixeli){
            System.out.println("tämä oli pixeli");
        }
        if (getColor().equals("Rainbow")){
            System.out.println("tämä on testi");
            double extraRollDamage = Math.random() * attack + 1;
            if(extraRollDamage > damage){
                damage = extraRollDamage;
            }
        }
        double randomNumber = Math.random();
        double criticalHitChange;
        if (getColor().equals("Orange")){
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
        double defendChange = 0.02;
        if (getColor().equals("Green")){
            defendChange = 0.1;
        }

        if (randomNumber < defendChange) {                                  //Dodge change
            System.out.println("Vihollinen oli liian ketterä lyönnillesi!");
            attack = 0;
        }
        double extraDefence = 0;
        double defenceRoll = defence * Math.random();
        if (getColor().equals("Gray")){
            System.out.println("Harmaa puolustaa!!");
            extraDefence = defence * Math.random();
            System.out.println("gray kyseessä"+extraDefence+ " "+defenceRoll);
            if (extraDefence > defenceRoll){
                defenceRoll = extraDefence;
                System.out.println("extra defenceeee");
            }
        }
        double damage = attack - defenceRoll; //Counts final damage after defending agaist attack
        if (damage < 0){
            damage = 0;
        }
        System.out.println("lopullinen damage defencen jälkeen: "+(int)damage);
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
