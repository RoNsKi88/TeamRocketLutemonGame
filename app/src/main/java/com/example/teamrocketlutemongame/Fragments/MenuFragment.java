package com.example.teamrocketlutemongame.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.teamrocketlutemongame.ActivityBattle;
import com.example.teamrocketlutemongame.ActivityStartMenu;
import com.example.teamrocketlutemongame.Battle;
import com.example.teamrocketlutemongame.R;
import com.example.teamrocketlutemongame.Recyclerview.PlayerLutemonAdapter;
import com.example.teamrocketlutemongame.Storage;


public class MenuFragment extends Fragment {
    private static View view;
    private RadioButton rbGameModeRandomBattle,rbGameModeTraining;
    private RadioButton rbDifficultyEasy,rbDifficultyNormal,rbDifficultyHard,rbDifficultyImpossible;
    private int difficultyMemory,gameModeMemory;
    TextView txtPlayerStats, txtPlayerWins, txtPlayerLosses;


    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu, container, false);
        txtPlayerStats = view.findViewById(R.id.txtPlayerStats);
        txtPlayerWins = view.findViewById(R.id.txtPlayerWins);
        txtPlayerLosses = view.findViewById(R.id.txtPlayerLosses);

        txtPlayerWins.setText("Wins: " + Storage.getInstance().getPlayer().getWins());
        txtPlayerLosses.setText("Losses: " + Storage.getInstance().getPlayer().getLosses());

        Button btnStartBattle = view.findViewById(R.id.btnStartBattle);
        Button btnBackToStartMenu = view.findViewById(R.id.btnBackToStartMenu);

        RadioGroup rgGameMode = view.findViewById(R.id.rgGameMode);
        RadioGroup rgDifficulty = view.findViewById(R.id.radioGroup);

        rbGameModeRandomBattle = view.findViewById(R.id.rbRandomBattle);
        rbGameModeTraining = view.findViewById(R.id.rbGameModeTraining);

        rbDifficultyEasy = view.findViewById(R.id.rbDifficultyEasy);
        rbDifficultyNormal = view.findViewById(R.id.rbDifficultyNormal);
        rbDifficultyHard = view.findViewById(R.id.rbDifficultyHard);
        rbDifficultyImpossible = view.findViewById(R.id.rbDifficultyImpossible);

        activateRadioButtonsFromMemory();   // Memory for radiobuttons in menu fragmet

        RecyclerView shownLutemon = view.findViewById(R.id.selectedCharacterLutemon);
        shownLutemon.setLayoutManager(new LinearLayoutManager(view.getContext()));
        shownLutemon.setAdapter(new PlayerLutemonAdapter(view.getContext(), Storage.getInstance().getPlayer().getPlayerLutemon()));

        btnStartBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Storage.getInstance().gameModeMemory = rgGameMode.getCheckedRadioButtonId();    // saves last selection of gamemode radiogroup
                Storage.getInstance().difficultyMemory = rgDifficulty.getCheckedRadioButtonId();// saves last selection of difficulty raidogroup.
                RadioButton rbGameMode = view.findViewById(rgGameMode.getCheckedRadioButtonId());
                String trainingMode = rbGameMode.getText().toString();

                RadioButton rbDifficulty = view.findViewById(rgDifficulty.getCheckedRadioButtonId());
                String difficulty = rbDifficulty.getText().toString();

                Battle.getInstace().setBattle(Storage.getInstance().getPlayer(),trainingMode,difficulty);   // setups the battle. "sends" player,training mode and difficulty to battle.
                Intent intent = new Intent(view.getContext(), ActivityBattle.class);
                startActivity(intent);

            }
        });
        btnBackToStartMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ActivityStartMenu.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
    public static void refresh(){                   // for refreshing a fragment.
        RecyclerView shownLutemon = view.findViewById(R.id.selectedCharacterLutemon);
        shownLutemon.setLayoutManager(new LinearLayoutManager(view.getContext()));
        shownLutemon.setAdapter(new PlayerLutemonAdapter(view.getContext(), Storage.getInstance().getPlayer().getPlayerLutemon()));

    }
    public void activateRadioButtonsFromMemory(){   // Memory for radiobuttons in menu fragmet
        difficultyMemory = Storage.getInstance().difficultyMemory;
        gameModeMemory = Storage.getInstance().gameModeMemory;

        switch (gameModeMemory){
            case (R.id.rbRandomBattle):
                rbGameModeRandomBattle.setChecked(true);
                break;
            case (R.id.rbGameModeTraining):
                rbGameModeTraining.setChecked(true);
                break;
            default:
                rbGameModeRandomBattle.setChecked(true);
                break;
        }
        switch (difficultyMemory){
            case (R.id.rbDifficultyEasy):
                rbDifficultyEasy.setChecked(true);
                break;
            case (R.id.rbDifficultyNormal):
                rbDifficultyNormal.setChecked(true);
                break;
            case (R.id.rbDifficultyHard):
                rbDifficultyHard.setChecked(true);
                break;
            case (R.id.rbDifficultyImpossible):
                rbDifficultyImpossible.setChecked(true);
                break;
            default:
                rbDifficultyNormal.setChecked(true);
                break;
        }
    }

}