package com.example.teamrocketlutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.teamrocketlutemongame.Lutemons.Orange;

public class ActivityStartMenu extends AppCompatActivity {
    ColorTheme colorTheme = new ColorTheme();
    Button btnNewGame,btnLoadGame,btnSaveGame,btnDeleteSave;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
        context = ActivityStartMenu.this;

        btnNewGame = findViewById(R.id.btnNewGame);
        btnLoadGame = findViewById(R.id.btnLoadGame);
        btnSaveGame = findViewById(R.id.btnSaveGame);
        //btnDeleteSave = findViewById(R.id.btnDeleteSave);

        btnNewGame.setOnClickListener(listener);
        btnLoadGame.setOnClickListener(listener);
        btnSaveGame.setOnClickListener(listener);
        //btnDeleteSave.setOnClickListener(listener);

    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent;
            switch (view.getId()){
                case (R.id.btnNewGame):
                    Storage.getInstance().getLutemons().clear();
                    Storage.getInstance().setPlayer(new Character("LutemonMestari"));
                    Storage.getInstance().getPlayer().setPlayerLutemon(new Orange("MaailmanMatkaaja",true));
                    intent = new Intent(ActivityStartMenu.this, ActivityMenu.class);
                    startActivity(intent);
                    break;
                case (R.id.btnSaveGame):

                    Storage.getInstance().saveLutemons(context);
                    break;
                case (R.id.btnLoadGame):

                    Storage.getInstance().loadLutemons(context);
                    intent = new Intent(ActivityStartMenu.this, ActivityMenu.class);
                    startActivity(intent);
                    break;
                default:
                    intent = new Intent(ActivityStartMenu.this, ActivityMenu.class);

                    break;
            }


        }
    };
}