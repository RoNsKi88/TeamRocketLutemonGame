package com.example.teamrocketlutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ActivityBattle extends AppCompatActivity {
    private Character player, enemy;
    private ImageView imgEnemy,imgPlayer;
    private Battle battle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        battle = Battle.getInstace();
        player = battle.getPlayer();
        enemy = battle.getEnemy();
        imgPlayer = findViewById(R.id.imgPlayer);
        imgEnemy = findViewById(R.id.imgEnemy);
        player.getPlayerLutemon().getColor();
        imgEnemy.setImageResource(player.getPlayerLutemon().imgFront);
        imgPlayer.setImageResource(player.getPlayerLutemon().imgBack);


    }
}