package com.example.teamrocketlutemongame;

import android.os.Handler;
import android.widget.ImageView;

public class Battle {
    private Character player,enemy;
    private static Battle battle = null;

    private Battle(){
    }

    public static Battle getInstace(){
        if (battle == null){
            battle = new Battle();
        }
        return battle;
    }

    public void setBattle(Character player,String mode,String difficulty) {
        System.out.println(player.getWins());
        player.getPlayerLutemon().resetHP();
        this.player = player;
        String color;
        enemy = new Character("Enemy");
        int boost = player.getWins();
        double helperInt = boost;
        switch (difficulty){
            case "Easy":
                helperInt *= 0.6;
                break;
            case "Normal":
                helperInt *= 0.8;
                break;
            case "Hard":
                helperInt = helperInt;
                break;
            case "Impossible":
                helperInt *= 1.2;
                break;
            default:
                helperInt = boost/4;
        }
        boost = (int)helperInt;

        switch (mode){
            case "Training":
                enemy.setPlayerLutemon(new Lutemon("Cashbag","Cashbag",boost,false));
                break;
            case "RandomBattle":
                enemy.setPlayerLutemon(new Lutemon("",boost));
                break;
            default:
                break;
        }



        enemy.getPlayerLutemon().resetHP();
    }
    public Character getPlayer(){
        return player;
    }
    public Character getEnemy(){
        return enemy;
    }



}
