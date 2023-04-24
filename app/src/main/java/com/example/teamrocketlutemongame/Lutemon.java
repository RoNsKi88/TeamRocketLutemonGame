package com.example.teamrocketlutemongame;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lutemon extends Specs {
    private final ArrayList<String> colors = new ArrayList<>(Arrays.asList("blue","white","red","yellow"));
    private final ArrayList<String> enemyNames = new ArrayList<>(Arrays.asList("SpagettiRyhmä","Työtön","Nuori osuja","Koodari","Lutesin Jäsen"));

    private int attack = 10;
    private int defence = 0;
    private int maxHealth = 20;
    private int health = maxHealth;
    private static int id = 0;

    private int level = 0;
    private float experience = 0;
    String color;
    int imgFront,imgBack;

    public Lutemon(String name, String color) {
        id = id++;
        this.name = name;
        this.color = color;
        addStats(color);

    }
    public Lutemon() {
        Random random = new Random();
        color = colors.get(random.nextInt(colors.size()));
        name = enemyNames.get(random.nextInt(enemyNames.size()));
        addStats(color);
    }
    private void addStats(String color){

        switch (color){
            case "blue":
                maxHealth += 10;
                health = maxHealth;
                imgFront = R.drawable.lute_front;
                imgBack = R.drawable.lute_back;
                break;
            case "white":
                defence += 10;
                imgFront = R.drawable.lute_front;
                imgBack = R.drawable.lute_back;
                break;
            case "red":
                attack += 10;
                imgFront = R.drawable.lute_front;
                imgBack = R.drawable.lute_back;
                break;
            case "yellow":
                imgFront = R.drawable.lute_front;
                imgBack = R.drawable.lute_back;

                break;
            case "rainbow":
                attack += 10;
                defence += 10;
                maxHealth +=10;
                health = maxHealth;
                imgFront = R.drawable.lute_front;
                imgBack = R.drawable.lute_back;
                break;
            default:
        }
    }
    private void levelUp(Lutemon lutemon){

        for (int i = 0;i < lutemon.getLevel();i++){

        }
    }
    public void printColor(){
        System.out.println(color);
    }
    public int makeAttack(){
        double damage = Math.random() * attack;
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
