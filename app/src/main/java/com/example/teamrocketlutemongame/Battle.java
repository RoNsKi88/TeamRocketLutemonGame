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
        int boost = player.getPlayerLutemon().getLevel();
        enemy = new Character("mulukku");
        enemy.setPlayerLutemon(new Lutemon(boost));
        enemy.getPlayerLutemon().resetHP();
    }
    public Character getPlayer(){
        return player;
    }
    public Character getEnemy(){
        return enemy;
    }

    public int attack(Character attacker,ImageView characterImage, float playerPosX, float playerPosY, float enemyPosX, float enemyPosY){
        int damage = attacker.getPlayerLutemon().makeAttack();
        characterImage.animate().x(enemyPosX).setDuration(600);
        characterImage.animate().y(enemyPosY);
        long lenOfAnimation = characterImage.animate().getDuration();
        Handler attackHandler = new Handler();

        attackHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                characterImage.animate().rotationXBy(360);
            }
        },lenOfAnimation/2);
        attackHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                characterImage.animate().x(playerPosX);
                characterImage.animate().y(playerPosY);
            }
        },lenOfAnimation-lenOfAnimation/5);
        return damage;
    }

}
