package com.example.teamrocketlutemongame;

import com.example.teamrocketlutemongame.Lutemons.CashBag;
import com.example.teamrocketlutemongame.Lutemons.Gray;
import com.example.teamrocketlutemongame.Lutemons.Green;
import com.example.teamrocketlutemongame.Lutemons.Orange;
import com.example.teamrocketlutemongame.Lutemons.Pink;
import com.example.teamrocketlutemongame.Lutemons.Pixeli;
import com.example.teamrocketlutemongame.Lutemons.Rainbow;

import java.util.Random;

public class Battle {
    private Character player,enemy;
    private String CreateLutemon;
    private Lutemon Opponent;
    public String difficulty;
    public double xpMultiplied;
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
        this.difficulty = difficulty;
        player.getPlayerLutemon().resetHP();
        this.player = player;
        enemy = new Character("Enemy");
        float karma = player.getWins() - player.getLosses();  // karma effects enemy difficulty.
        if (karma < 0){karma = 0;}
        Random random = new Random();
        String enemyLutemonName = Lutemon.enemyNames.get(random.nextInt(Lutemon.enemyNames.size())); //gets random lutemon name for enemy.


        switch (difficulty){    // difficulty
            case "Easy":
                karma *= 0.6;
                xpMultiplied = 0.5;
                break;
            case "Normal":
                karma *= 0.8;
                xpMultiplied = 0.75;
                break;
            case "Hard":
                karma *= 1;
                xpMultiplied = 1;
                break;
            case "Impossible":
                karma *= 1.4;
                xpMultiplied = 1;
                break;
            default:
                karma = karma;
        }
        int boost = (int)karma;

        switch (mode){
            case "Training":
                Opponent = new CashBag("Cashbag",false);
                Opponent.boost(boost);
                enemy.setPlayerLutemon(Opponent);
                break;
            case "RandomBattle":
                int winRate = player.getWins()-player.getLosses();
                if((winRate % 10) == 0 && winRate != 0 ){
                    Opponent = new Pixeli("YberPixeli",false);
                    Opponent.boost(boost * 2);
                    enemy.setPlayerLutemon(Opponent);
                    break;
                }
                random = new Random();
                CreateLutemon = Lutemon.colors.get(random.nextInt(Lutemon.colors.size()-1)); // Makes it so Pixeli doesnt appear as random enemy
                if (CreateLutemon.equals("Green")) {
                    Opponent = new Green(enemyLutemonName,false);
                    Opponent.boost(boost);
                    enemy.setPlayerLutemon(Opponent);
                    break;
                }else if (CreateLutemon.equals("Orange")) {
                    Opponent = new Orange(enemyLutemonName,false);
                    Opponent.boost(boost);
                    enemy.setPlayerLutemon(Opponent);
                    break;
                }else if (CreateLutemon.equals("Rainbow")) {
                    Opponent = new Rainbow(enemyLutemonName,false);
                    Opponent.boost(boost);
                    enemy.setPlayerLutemon(Opponent);
                    break;
                }else if (CreateLutemon.equals("Gray")) {
                    Opponent = new Gray(enemyLutemonName,false);
                    Opponent.boost(boost);
                    enemy.setPlayerLutemon(Opponent);
                    break;
                }else if (CreateLutemon.equals("Pink")) {
                    Opponent = new Pink(enemyLutemonName,false);
                    Opponent.boost(boost);
                    enemy.setPlayerLutemon(Opponent);
                    break;
                }
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
