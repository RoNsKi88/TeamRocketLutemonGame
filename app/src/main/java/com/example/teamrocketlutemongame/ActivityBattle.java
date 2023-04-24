package com.example.teamrocketlutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ActivityBattle extends AppCompatActivity {
    private Character player, enemy;
    private ImageView imgEnemy,imgPlayer;
    private Battle battle;
    private Button btnAttack;
    private TextView txtPlayerHP,txtEnemyHP,txtPlayerName, txtEnemyName;



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

        ProgressBar progressBarPlayer = findViewById(R.id.progressBarPlayer);
        ProgressBar progressBarEnemy = findViewById(R.id.progressBarEnemy);
        progressBarEnemy.setProgress(100);
        progressBarPlayer.setProgress(100);


        txtEnemyHP = findViewById(R.id.txtEnemyHP);
        txtEnemyHP.setText("HP "+enemy.getPlayerLutemon().getHP()+"/"+enemy.getPlayerLutemon().getHP());

        txtEnemyName = findViewById(R.id.txtEnemyName);
        txtEnemyName.setText(enemy.getPlayerLutemon().getName());

        txtPlayerName = findViewById(R.id.txtPlayerName);
        txtPlayerName.setText(player.getPlayerLutemon().getName());

        txtPlayerHP = findViewById(R.id.txtPlayerHP);
        txtPlayerHP.setText("HP "+player.getPlayerLutemon().getHP()+"/"+player.getPlayerLutemon().getHP());




        btnAttack = findViewById(R.id.btnAttack);
        btnAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final float playerPosX = imgPlayer.getX();
                final float playerPosY = imgPlayer.getY();
                final float enemyPosY = imgEnemy.getY();
                final float enemyPosX = imgEnemy.getX();
                int damage;
                Handler attackHandler = new Handler();







                btnAttack.setVisibility(View.GONE);

                damage = battle.attack(player,imgPlayer,playerPosX,playerPosY,enemyPosX,enemyPosY);

                damage = enemy.getPlayerLutemon().defend(damage);
                txtEnemyHP.setText("HP "+enemy.getPlayerLutemon().getHP()+"/"+enemy.getPlayerLutemon().getMaxHP());

                int progress = (int)((float) enemy.getPlayerLutemon().getHP()/(float) enemy.getPlayerLutemon().getMaxHP()*100);
                progressBarEnemy.setProgress(progress,true);
                attackHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (enemy.getPlayerLutemon().getHP() > 0) {
                            int damage;
                            damage = battle.attack(enemy,imgEnemy, enemyPosX, enemyPosY, playerPosX, playerPosY);
                            damage = player.getPlayerLutemon().defend(damage);
                            txtPlayerHP.setText("HP "+player.getPlayerLutemon().getHP()+"/"+player.getPlayerLutemon().getMaxHP());
                            int progress = (int)((float) player.getPlayerLutemon().getHP()/(float) player.getPlayerLutemon().getMaxHP()*100);
                            progressBarPlayer.setProgress(progress,true);

                        }
                        else {
                            imgEnemy.animate().rotationX(60);
                        }
                    }
                },1500);

                attackHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (player.getPlayerLutemon().getHP() > 0) {

                        }
                        else {
                            imgPlayer.animate().rotationX(-60);
                        }
                    }
                },1500);

                btnAttack.setVisibility(View.VISIBLE);

            }
        });








    }
}