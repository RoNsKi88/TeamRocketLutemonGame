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

import com.example.teamrocketlutemongame.ActivityBattle;
import com.example.teamrocketlutemongame.Battle;
import com.example.teamrocketlutemongame.R;
import com.example.teamrocketlutemongame.Recyclerview.LutemonRecyclerViewAdapter;
import com.example.teamrocketlutemongame.Recyclerview.PlayerLutemonAdapter;
import com.example.teamrocketlutemongame.Storage;

import java.util.Random;


public class MenuFragment extends Fragment {
    private static View view;


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

        Button btnStartBattle = view.findViewById(R.id.btnStartBattle);
        RadioGroup rgGameMode = view.findViewById(R.id.rgGameMode);
        RadioGroup rgDifficulty = view.findViewById(R.id.radioGroup);


        RadioButton rbGameModeRandomBattle = view.findViewById(R.id.rbRandomBattle);
        rbGameModeRandomBattle.setChecked(true);
        RadioButton rbDifficultyNormal = view.findViewById(R.id.rbDifficultyNormal);
        rbDifficultyNormal.setChecked(true);



        RecyclerView shownLutemon = view.findViewById(R.id.selectedCharacterLutemon);
        shownLutemon.setLayoutManager(new LinearLayoutManager(view.getContext()));
        shownLutemon.setAdapter(new PlayerLutemonAdapter(view.getContext(), Storage.getInstance().getPlayer().getPlayerLutemon()));

        btnStartBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = view.findViewById(rgGameMode.getCheckedRadioButtonId());
                String trainingMode = rb.getText().toString();

                RadioButton rbDifficulty = view.findViewById(rgDifficulty.getCheckedRadioButtonId());
                String difficulty = rbDifficulty.getText().toString();

                Battle.getInstace().setBattle(Storage.getInstance().getPlayer(),trainingMode,difficulty);
                Intent intent = new Intent(view.getContext(), ActivityBattle.class);
                startActivity(intent);

            }
        });


        // Inflate the layout for this fragment
        return view;
    }
    public static void refresh(){
        RecyclerView shownLutemon = view.findViewById(R.id.selectedCharacterLutemon);
        shownLutemon.setLayoutManager(new LinearLayoutManager(view.getContext()));
        shownLutemon.setAdapter(new PlayerLutemonAdapter(view.getContext(), Storage.getInstance().getPlayer().getPlayerLutemon()));

    }

}