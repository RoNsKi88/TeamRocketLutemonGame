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
    public int getLutemonHP(Character player){
        return player.getPlayerLutemon().getHP();
    }

    public int attack(Character attacker,ImageView kuva, float playerPosX, float playerPosY, float enemyPosX, float enemyPosY){
        float startPosX,startPosY,endPosX,endPosY;

        int damage = attacker.getPlayerLutemon().makeAttack();


        kuva.animate().x(enemyPosX).setDuration(600);
        kuva.animate().y(enemyPosY);
        long lenOfAnimation = kuva.animate().getDuration();
        Handler attackHandler = new Handler();

        attackHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                kuva.animate().rotationXBy(360);
            }
        },lenOfAnimation/2);
        attackHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                kuva.animate().x(playerPosX);
                kuva.animate().y(playerPosY);
            }
        },lenOfAnimation-lenOfAnimation/5);
        return damage;
    }

}
