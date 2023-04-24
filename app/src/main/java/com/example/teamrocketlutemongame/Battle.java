package com.example.teamrocketlutemongame;

import java.util.Calendar;

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

    public void setBattle(Character player) {
        this.player = player;
        player.getPlayerLutemon().getLevel();
        enemy = new Character("mulukku");
        enemy.setPlayerLutemon(new Lutemon());
    }
    public Character getPlayer(){
        return player;
    }
    public Character getEnemy(){
        return enemy;
    }
}
