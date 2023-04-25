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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        RecyclerView shownLutemon = view.findViewById(R.id.selectedCharacterLutemon);
        Button btnStartBattle = view.findViewById(R.id.btnStartBattle);
        RadioGroup rgGameMode = view.findViewById(R.id.rgGameMode);
        RadioGroup rgDifficulty = view.findViewById(R.id.radioGroup);


        RadioButton rbGameModeRandomBattle = view.findViewById(R.id.rbRandomBattle);
        rbGameModeRandomBattle.setChecked(true);
        RadioButton rbDifficultyNormal = view.findViewById(R.id.rbDifficultyNormal);
        rbDifficultyNormal.setChecked(true);




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

}