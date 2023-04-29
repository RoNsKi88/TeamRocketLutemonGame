package com.example.teamrocketlutemongame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teamrocketlutemongame.Lutemons.CashBag;
import com.example.teamrocketlutemongame.Lutemons.Pink;
import com.example.teamrocketlutemongame.Lutemons.Pixeli;

public class ActivityBattle extends AppCompatActivity {
    private Character player, enemy;
    private ImageView imgEnemy,imgPlayer;
    private Battle battle;
    private Button btnAttack, btnBackToMenu;
    private TextView txtPlayerHP,txtEnemyHP,txtPlayerName, txtEnemyName,txtWinner,txtDamageNumber, txtEnemyLevel,txtPlayerLevel;
    private int damage,playerMaxHP,enemyMaxHP;
    private float playerPosX,playerPosY,enemyPosY,enemyPosX;
    private long animationTimer;
    private Handler attackHandler = new Handler();
    private ConstraintLayout winningScreen;
    private double xpMultiplier;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        context = ActivityBattle.this;
        xpMultiplier = Battle.getInstace().xpMultiplied;

        battle = Battle.getInstace();
        player = battle.getPlayer();
        enemy = battle.getEnemy();
        imgPlayer = findViewById(R.id.imgPlayer);
        imgEnemy = findViewById(R.id.imgEnemy);

        imgEnemy.setImageResource(enemy.getPlayerLutemon().imgFront);
        imgPlayer.setImageResource(player.getPlayerLutemon().imgBack);
        txtDamageNumber = findViewById(R.id.txtDamageNro);

        txtPlayerLevel = findViewById(R.id.txtPlayerLevel);
        txtEnemyLevel = findViewById(R.id.txtEnemyLevel);
        txtPlayerLevel.setText("LVL: "+String.valueOf(player.getPlayerLutemon().getLevel()));
        txtEnemyLevel.setText("LVL: "+String.valueOf(enemy.getPlayerLutemon().getLevel()));

        winningScreen = findViewById(R.id.winningScreen);
        winningScreen.setVisibility(View.GONE);
        txtWinner = findViewById(R.id.txtWinnerLoser);
        btnBackToMenu = findViewById(R.id.btnBackToMenu);


        playerMaxHP = player.getPlayerLutemon().getMaxHP();
        enemyMaxHP = enemy.getPlayerLutemon().getMaxHP();
        btnBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.getPlayerLutemon().resetHP();
                Storage.getInstance().saveLutemons(v.getContext());
                Intent intent = new Intent(ActivityBattle.this,ActivityMenu.class);
                startActivity(intent);
            }
        });


        ProgressBar progressBarPlayer = findViewById(R.id.progressBarPlayer);
        ProgressBar progressBarEnemy = findViewById(R.id.progressBarEnemy);
        progressBarEnemy.setProgress(100);
        progressBarPlayer.setProgress(100);

        txtEnemyHP = findViewById(R.id.txtEnemyHP);
        txtEnemyHP.setText("HP: "+enemy.getPlayerLutemon().getHP());

        txtEnemyName = findViewById(R.id.txtEnemyName);
        txtEnemyName.setText(enemy.getPlayerLutemon().getName());

        txtPlayerName = findViewById(R.id.txtPlayerName);
        txtPlayerName.setText(player.getPlayerLutemon().getName());

        txtPlayerHP = findViewById(R.id.txtPlayerHP);
        txtPlayerHP.setText("HP: "+player.getPlayerLutemon().getHP());

        btnAttack = findViewById(R.id.btnAttack);
        btnAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerPosX = imgPlayer.getX();
                playerPosY = imgPlayer.getY();
                enemyPosY = imgEnemy.getY();
                enemyPosX = imgEnemy.getX();
                Handler attackHandler = new Handler();
                btnAttack.setVisibility(View.GONE);
                animationTimer = 0; // counter for animations.
                while (player.getPlayerLutemon().getHP() > 0 && enemy.getPlayerLutemon().getHP() > 0) { //simulate battle.


                    //player attack//

                    damage = player.getPlayerLutemon().makeAttack();    // function return lutemons generated damage
                    damage = enemy.getPlayerLutemon().defend(damage);   // function defends agaist enemy attack. and returns total damage done
                    int hpLeft = enemy.getPlayerLutemon().getHP();

                    if(player.getPlayerLutemon().addXP(damage * xpMultiplier)){ // Function return true if lutemon gets level.
                        Toast toast = Toast.makeText(context,"LevelUP!!!!!",Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    }
                    attackAnimation(player.getPlayerLutemon(),enemy.getPlayerLutemon(), txtEnemyHP, damage, hpLeft, enemyMaxHP, imgPlayer, progressBarEnemy, playerPosX, playerPosY, enemyPosX, enemyPosY);
                    if (player.getPlayerLutemon() instanceof Pink) { // pinks Speciality
                        player.getPlayerLutemon().setHP((int) (damage * 0.3));
                    }
                    //player attack ends//

                    //enemy turn//
                    if (enemy.getPlayerLutemon().getHP() > 0) { //Enemy alive check.
                        damage = enemy.getPlayerLutemon().makeAttack();
                        damage = player.getPlayerLutemon().defend(damage);
                        hpLeft = player.getPlayerLutemon().getHP();
                        attackAnimation(enemy.getPlayerLutemon(),player.getPlayerLutemon(), txtPlayerHP, damage, hpLeft, playerMaxHP, imgEnemy, progressBarPlayer, enemyPosX, enemyPosY, playerPosX, playerPosY);
                        if (enemy.getPlayerLutemon() instanceof Pink) {
                            enemy.getPlayerLutemon().setHP((int) (damage * 0.1));
                        }
                    } else {                                      //if dead.
                        attackHandler.postDelayed(new Runnable() {                  //attacker movement over opponent with delay
                            @Override
                            public void run() {
                                System.out.println(enemy.getPlayerLutemon().getName() + "Menehtyi traagisesti.");
                                imgEnemy.animate().rotationX(60);
                                imgEnemy.animate().alpha(0).setDuration(1000);
                                if (!(enemy.getPlayerLutemon() instanceof CashBag)) {
                                    player.setWins();
                                    player.getPlayerLutemon().setWins();
                                }else{
                                    player.setTrainingDays();
                                    if(player.getTrainingDays() == 10){ //Easter egg. get 10 training days to unlock
                                        Toast toast = Toast.makeText(ActivityBattle.this,"Onneksiolkoon! Löysit easterEgin!\nYllätys lisätty varastoon!",Toast.LENGTH_LONG);
                                        toast.setGravity(Gravity.BOTTOM,0,0);
                                        toast.show();
                                        Lutemon easterEggCashBag = new CashBag("MinunRahet",true);
                                        easterEggCashBag.attack += 100;
                                        Storage.getInstance().addLutemon(easterEggCashBag);
                                    }
                                }

                                txtWinner.setText("You Win!");
                                winningScreen.setVisibility(View.VISIBLE);
                                btnAttack.setVisibility(View.GONE);
                            }
                        }, animationTimer);
                    }
                    //enemy turn ends//
                    if (player.getPlayerLutemon().getHP() <= 0) {   //player alive check.
                        attackHandler.postDelayed(new Runnable() {  //player health check.
                            @Override
                            public void run() {
                                System.out.println(player.getPlayerLutemon().getName() + " Menehtyi traagisesti.");
                                imgPlayer.animate().alpha(0).setDuration(1000);// else end combat.
                                imgPlayer.animate().rotationX(-60);    // rotates lutemon if dead
                                player.getPlayerLutemon().setLosses();
                                player.setLosses();
                                txtWinner.setText("You Lose!");
                                winningScreen.setVisibility(View.VISIBLE);
                                btnAttack.setVisibility(View.GONE);

                                if (player.getPlayerLutemon().getHcStatus()) {   // if lutemon has hc status
                                    txtWinner.setText("You Lose! " + player.getPlayerLutemon().getName() + " on siirtynyt hautausmaalle :'(");
                                    Storage.getInstance().addDeadLutemon(player.getPlayerLutemon());
                                    if (Storage.getInstance().getLutemons().size() == 0) {  // easteregg lose all lutemons to gain pixeli. can happen multiple times.
                                        Toast toast = Toast.makeText(ActivityBattle.this,"Listaltasi loppui lutemonit.\nOta siitä pixeli piristämään päivää!",Toast.LENGTH_LONG);
                                        toast.setGravity(Gravity.BOTTOM,0,0);
                                        toast.show();
                                        player.setPlayerLutemon(new Pixeli("Pixeli", true));
                                    } else {
                                        player.setPlayerLutemon(Storage.getInstance().getLutemon(0));
                                        Storage.getInstance().removeLutemon(0);
                                    }
                                }
                            }
                        }, animationTimer);
                    }
                }
            }public long attackAnimation(Lutemon attacker,Lutemon defender,TextView txtenemyHP,int damage,int hpLeft,int opponentMaxHp, ImageView characterImage,ProgressBar opponentHpBar, float attackerPosX, float attackerPosY, float defenderPosX, float defenderPosY){
                characterImage.animate().setDuration(400);



                attackHandler.postDelayed(new Runnable() {                  //attacker movement over opponent
                    @Override
                    public void run() {
                        characterImage.animate().x(defenderPosX).y(defenderPosY);
                    }
                },animationTimer);
                attackHandler.postDelayed(new Runnable() {                  //start animating flip half way to opponent
                    @Override
                    public void run() {
                        characterImage.animate().rotationXBy(360);
                        refreshHealthStatus(txtenemyHP,hpLeft,opponentMaxHp,opponentHpBar);
                    }
                },animationTimer + characterImage.animate().getDuration()/2);
                animationTimer += characterImage.animate().getDuration();   //add delay for animations.
                attackHandler.postDelayed(new Runnable(){                  //re position attacker to its start position.
                    @Override
                    public void run() {
                        txtDamageNumber.setText(String.valueOf(damage));
                        txtDamageNumber.setX(defenderPosX);
                        txtDamageNumber.setY(defenderPosY);
                        txtDamageNumber.animate().alpha(1);
                        System.out.println(attacker.getName()+": teki "+ damage + " vahinkoa " + defender.getName() + ":iin");
                        attackHandler.postDelayed(new Runnable() {                  //re position attacker to its start position.
                            @Override
                            public void run() {
                                txtDamageNumber.animate().alpha(0);
                            }
                        },txtDamageNumber.animate().getDuration());

                        characterImage.animate().x(attackerPosX).y(attackerPosY);
                    }
                },animationTimer);
                animationTimer += characterImage.animate().getDuration();   //add delay for animations.
                return animationTimer;
            }
            public void refreshHealthStatus(TextView characterHP,int hpLeft,int opponentMaxHp,ProgressBar progressBar){ //refresh characters stats.
                int progress;

                if (hpLeft < 0) {
                    characterHP.setText("HP: " + 0);
                }else {
                    characterHP.setText("HP: " + hpLeft);
                }
                progress = (int)((float) hpLeft/(float) opponentMaxHp*100);
                progressBar.setProgress(progress,true);

            }
        });
    }
}