package com.example.teamrocketlutemongame;

import android.os.Handler;
import android.widget.ImageView;

import com.example.teamrocketlutemongame.Lutemons.CashBag;
import com.example.teamrocketlutemongame.Lutemons.Gray;
import com.example.teamrocketlutemongame.Lutemons.Green;
import com.example.teamrocketlutemongame.Lutemons.Orange;
import com.example.teamrocketlutemongame.Lutemons.Pink;
import com.example.teamrocketlutemongame.Lutemons.Rainbow;

import java.util.Random;

public class Battle {
    private Character player,enemy;
    private String CreateLutemon;
    private Lutemon Opponent;
    public String difficulty;
    public int xpMultiplied;
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
        System.out.println(player.getWins());
        player.getPlayerLutemon().resetHP();
        this.player = player;
        String color;
        enemy = new Character("Enemy");
        int karma = player.getWins() - player.getLosses();
        if (karma < 0){karma = 0;}


        switch (difficulty){
            case "Easy":
                karma *= 1;
                xpMultiplied = 1;
                break;
            case "Normal":
                karma *= 2;
                xpMultiplied = 2;
                break;
            case "Hard":
                karma *= 4;
                xpMultiplied = 4;
                break;
            case "Impossible":
                karma *= 8;
                xpMultiplied = 8;
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
                Random random = new Random();
                CreateLutemon = Lutemon.colors.get(random.nextInt(Lutemon.colors.size()-1)); // Makes it so Pixeli doesnt appear as random enemy
                if (CreateLutemon.equals("Green")) {
                    Opponent = new Green("",false);
                    Opponent.boost(boost);
                    enemy.setPlayerLutemon(Opponent);
                    break;
                }else if (CreateLutemon.equals("Orange")) {
                    Opponent = new Orange("",false);
                    Opponent.boost(boost);
                    enemy.setPlayerLutemon(Opponent);
                    break;
                }else if (CreateLutemon.equals("Rainbow")) {
                    Opponent = new Rainbow("",false);
                    Opponent.boost(boost);
                    enemy.setPlayerLutemon(Opponent);
                    break;
                }else if (CreateLutemon.equals("Gray")) {
                    Opponent = new Gray("",false);
                    Opponent.boost(boost);
                    enemy.setPlayerLutemon(Opponent);
                    break;
                }else if (CreateLutemon.equals("Pink")) {
                    Opponent = new Orange("",false);
                    Opponent.boost(boost);
                    enemy.setPlayerLutemon(Opponent);
                    break;
                }
                // System.out.println("Ei osunut mihinkään, kokeillaan uudelleen...");

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
