package com.example.teamrocketlutemongame;

public class Lutemon extends Specs {
    int attack = 1;
    int defence = 0;
    int maxHealth = 20;
    int health = maxHealth;

    int level = 0;
    float experience = 0;
    String color;

    public Lutemon(String name, String color) {

        this.color = color;
        switch (color){
            case "blue":
                maxHealth += 10;
                health = maxHealth;

                break;
            case "white":
                defence += 10;
                break;
            case "red":
                attack += 10;
                break;
            case "yellow":

                break;
            case "rainbow":
                attack += 10;
                defence += 10;
                maxHealth +=10;
                health = maxHealth;
            default:


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

}
