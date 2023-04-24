package com.example.teamrocketlutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMenu extends AppCompatActivity {
    private Button btnStartBattle;
    private Battle battle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Väliaikais ukkeli + lutemon luonti
        Character character = new Character("keijo");
        character.setPlayerLutemon(new Lutemon());
        System.out.println(character.getPlayerLutemon().getName()+"    ukon lutikka  "+ character.getPlayerLutemon().getColor()+ "    väri      "+"PERKELE TÄÄLLÄ ON PASKAA");

        Storage.getInstance().setPlayer(character);





        btnStartBattle = findViewById(R.id.btnStartBattle);
        btnStartBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                battle.getInstace().setBattle(Storage.getInstance().getPlayer());
                Intent intent = new Intent(ActivityMenu.this,ActivityBattle.class);
                startActivity(intent);
            }
        });








    }
}