package com.example.teamrocketlutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityStartMenu extends AppCompatActivity {
    ColorTheme colorTheme = new ColorTheme();
    Button btnNewGame,btnLoadGame,btnSaveGame,btnDeleteSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        btnNewGame = findViewById(R.id.btnNewGame);
        btnLoadGame = findViewById(R.id.btnLoadGame);
        btnSaveGame = findViewById(R.id.btnSaveGame);
        //btnDeleteSave = findViewById(R.id.btnDeleteSave);

        btnNewGame.setOnClickListener(listener);
        btnLoadGame.setOnClickListener(listener);
        btnSaveGame.setOnClickListener(listener);
        //btnDeleteSave.setOnClickListener(listener);

        // Väliaikais ukkeli + lutemon luonti
        Character character = new Character("matti");
        character.setPlayerLutemon(new Lutemon("reiskaperäreikä","Rainbow",20));
        System.out.println(character.getPlayerLutemon().getName()+"    ukon lutikka  "+ character.getPlayerLutemon().getColor()+ "    väri      "+"PERKELE TÄÄLLÄ ON PASKAA");

        Storage.getInstance().setPlayer(character);


    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent;
            switch (view.getId()){
                case (R.id.btnNewGame):
                    intent = new Intent(ActivityStartMenu.this, ActivityMenu.class);
                    break;
                default:
                    intent = new Intent(ActivityStartMenu.this, ActivityMenu.class);

                    break;
            }
            startActivity(intent);

        }
    };
}