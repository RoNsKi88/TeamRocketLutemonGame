package com.example.teamrocketlutemongame;

import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lutemon extends Specs implements Serializable {
    private final ArrayList<String> colors = new ArrayList<>(Arrays.asList("Gray","Green","Orange","Pink","Rainbow"));
    public static final ArrayList<String> enemyNames = new ArrayList<>(Arrays.asList("SpagettiRyhmä","Työtön","NuoriOsuja","Koodari","LutesinJäsen","Ruotsintentti","Matematiikantentti","Teppo Tarkka-ampuja","Mr Vac"));



    public static final ArrayList<String> randomLutemonNames = new ArrayList<>(Arrays.asList("Jorma","Kaaleppi","Reiska","PatonkiAnneli","RoNsKi","Keijo","ErittäinKovaKivi!","KovinKivi","KumiTarzan"));

    private int attack = 5;
    private int defence = 0;
    private int maxHealth = 20;
    private int health = maxHealth;
    private String special = "jumalanSiunaus";
    private static int id = 0;
    private boolean hardcore;
    private int level = 1;
    double lvlUP = 10;
    private float experience = 0;
    private String color;
    int imgFront,imgBack;

    public Lutemon(String name, String color,int boost, boolean HC) {
        id = id++;
        this.name = name;
        this.color = color;
        this.hardcore = HC;
        addStats(color);


        for (int i=0;i<boost;i++){
            if (name.equals("Cashbag")){
                maxHealth += i;
            }
            else{
                levelUp();
                level += 1;
            }
        }
    }

    public Lutemon(String name,int boost) {
        Random random = new Random();
        color = colors.get(random.nextInt(colors.size()));
        if (name == "Cashbag" ) {
            this.name = enemyNames.get(random.nextInt(enemyNames.size()));
            color = "Cashbag";
        }
        else {
            this.name = name;
        }
        addStats(color);

        for (int i = 0;i<boost;i++){
            levelUp();
            level += 1;
        }
    }
    private void addStats(String color){

        switch (color){
            case "Gray":
                maxHealth += 10;
                health = maxHealth;
                imgFront = R.drawable.gray_front;
                imgBack = R.drawable.gray_back;
                special = "RollExtreDef";
                break;
            case "Green":
                defence += 10;
                imgFront = R.drawable.green_front;
                imgBack = R.drawable.green_back;
                special = "IgnoreDmg";
                break;
            case "Orange":
                attack += 10;
                imgFront = R.drawable.orange_front;
                imgBack = R.drawable.orange_back;
                special = "CritHitChange";
                break;
            case "Pink":
                maxHealth += 5;
                attack += 2;
                defence += 2;
                imgFront = R.drawable.pink_front;
                imgBack = R.drawable.pink_back;
                special = "Leech";

                break;
            case "Rainbow":
                attack += 10;
                defence += -10;
                maxHealth +=10;
                health = maxHealth;
                imgFront = R.drawable.rain_front;
                imgBack = R.drawable.rain_back;
                special = "Nothing";
                break;
            case "Cashbag":
                attack = 1;
                defence = 0;
                maxHealth = 20;
                health = maxHealth;
                imgFront = R.drawable.cash_bag;
                imgBack = R.drawable.cash_bag;
                special = "Just a CashBag";

            default:
        }
    }
    public void addXP(int points){
        experience += points;

        if (experience > lvlUP){
            levelUp();
            level += 1;
            experience = 0;
        }
    }
    private void levelUp(){
        int j;
        lvlUP *= 1.3;
        for (int i = 0;i < level;i++){
            Random random = new Random();
            j = (int)(Math.random()*3);
            switch (j){
                case 0:
                    attack += 1;
                    break;
                case 1:
                    defence += 1;
                    break;
                case 2:
                    maxHealth += 1;
                    break;
            }
        }
    }
    public int makeAttack(){
        double damage = Math.random() * attack + 1;
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
        health -= damage;
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
