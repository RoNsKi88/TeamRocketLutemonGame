package com.example.teamrocketlutemongame;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lutemon extends Specs {
    private final ArrayList<String> colors = new ArrayList<>(Arrays.asList("gray","green","orange","pink","rainbow","cashbag"));
    private final ArrayList<String> enemyNames = new ArrayList<>(Arrays.asList("SpagettiRyhmä","Työtön","Nuori osuja","Koodari","Lutesin Jäsen"));

    private int attack = 10;
    private int defence = 0;
    private int maxHealth = 20;
    private int health = maxHealth;
    private static int id = 0;

    private int level = 1;
    double lvlUP = 10;
    private float experience = 0;
    private String color;
    int imgFront,imgBack;

    public Lutemon(String name, String color,int boost) {
        id = id++;
        this.name = name;
        this.color = color;
        addStats(color);
        for (int i=0;i<boost;i++){
            if (color.equals("cashbag")){
                maxHealth += i;
            }
            else{
                levelUp();
                level += 1;
            }
        }
    }

    public Lutemon(int boost) {
        Random random = new Random();
        color = colors.get(random.nextInt(colors.size()));
        name = enemyNames.get(random.nextInt(enemyNames.size()));
        addStats(color);
        for (int i = 0;i<boost;i++){
            levelUp();
            level += 1;
        }
    }
    private void addStats(String color){

        switch (color){
            case "gray":
                maxHealth += 10;
                health = maxHealth;
                imgFront = R.drawable.gray_front;
                imgBack = R.drawable.gray_back;
                break;
            case "green":
                defence += 10;
                imgFront = R.drawable.green_front;
                imgBack = R.drawable.green_back;
                break;
            case "orange":
                attack += 10;
                imgFront = R.drawable.orange_front;
                imgBack = R.drawable.orange_back;
                break;
            case "pink":
                imgFront = R.drawable.pink_front;
                imgBack = R.drawable.pink_back;

                break;
            case "rainbow":
                attack += 10;
                defence += 10;
                maxHealth +=10;
                health = maxHealth;
                imgFront = R.drawable.rain_front;
                imgBack = R.drawable.rain_back;
                break;
            case "cashbag":
                attack = 1;
                defence = 0;
                maxHealth = 20;
                health = maxHealth;
                imgFront = R.drawable.cash_bag;
                imgBack = R.drawable.cash_bag;

            default:
        }
    }
    public void addXP(int points){
        experience += points;

        if (experience > lvlUP){
            levelUp();
            level += 1;
            System.out.println("levelUP!");
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
                    System.out.println("attacklvlup");
                    break;
                case 1:
                    defence += 1;
                    System.out.println("defencelvlup");
                    break;
                case 2:
                    maxHealth += 1;
                    System.out.println("maxhealthlvlup");
                    break;
            }
        }
    }
    public int makeAttack(){
        double damage = Math.random() * attack + 1;
        System.out.println("Damage number: "+ (int)damage);
        return (int) damage;
    }
    public int defend(int attack){
        double damage = attack - (defence * Math.random());
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
    public int getMaxHP(){
        return maxHealth;
    }
    public void resetHP(){
        health = maxHealth;
    }

}
