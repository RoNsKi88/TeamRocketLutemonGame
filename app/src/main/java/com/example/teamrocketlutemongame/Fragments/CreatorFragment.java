package com.example.teamrocketlutemongame.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.teamrocketlutemongame.ActivityMenu;
import com.example.teamrocketlutemongame.Lutemon;
import com.example.teamrocketlutemongame.Lutemons.Gray;
import com.example.teamrocketlutemongame.Lutemons.Green;
import com.example.teamrocketlutemongame.Lutemons.Orange;
import com.example.teamrocketlutemongame.Lutemons.Pink;
import com.example.teamrocketlutemongame.Lutemons.Pixeli;
import com.example.teamrocketlutemongame.Lutemons.Rainbow;
import com.example.teamrocketlutemongame.R;
import com.example.teamrocketlutemongame.Storage;

import java.util.Random;


public class CreatorFragment extends Fragment {
    public CreatorFragment() {
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
        View view = inflater.inflate(R.layout.fragment_creator, container, false);
        ImageView imgLutemon = view.findViewById(R.id.imgLutemon);
        imgLutemon.setImageResource(R.drawable.gray_front);
        Spinner spinnerLutemons = view.findViewById(R.id.spinnerLutemons);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),R.array.Lutemons, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLutemons.setAdapter(adapter);
        TextView textviewHP = view.findViewById(R.id.textCreateHP);
        TextView textviewAttack = view.findViewById(R.id.textCreateAttack);
        TextView textviewDefence = view.findViewById(R.id.textCreateDefence);
        TextView textviewSpecial = view.findViewById(R.id.textCreateSpecial);
        Button btnCreateLutemon = view.findViewById(R.id.CreateBtn);
        TextView TextviewName = view.findViewById(R.id.txtInputName);
        CheckBox cb = view.findViewById((R.id.CreateCb));
        Lutemon esivalinta;




        spinnerLutemons.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Lutemon esivalinta = new Gray("", true);
                        imgLutemon.setImageResource(esivalinta.getImgFront());
                        textviewHP.setText("HP: " + Integer.toString(esivalinta.getHP()));

                        textviewAttack.setText("ATT: " + Integer.toString(esivalinta.getAtk()));
                        textviewDefence.setText("DEF: " + Integer.toString(esivalinta.getDef()));
                        textviewSpecial.setText("Special: " + esivalinta.getSpecial());
                        break;
                    case 1:

                        esivalinta = new Green("", true);
                        imgLutemon.setImageResource(esivalinta.getImgFront());
                        textviewHP.setText("HP: " + Integer.toString(esivalinta.getHP()));

                        textviewAttack.setText("ATT: " + Integer.toString(esivalinta.getAtk()));
                        textviewDefence.setText("DEF: " + Integer.toString(esivalinta.getDef()));
                        textviewSpecial.setText("Special: " + esivalinta.getSpecial());
                        break;
                    case 2:

                        esivalinta = new Orange("", true);
                        imgLutemon.setImageResource(esivalinta.getImgFront());
                        textviewHP.setText("HP: " + Integer.toString(esivalinta.getHP()));

                        textviewAttack.setText("ATT: " + Integer.toString(esivalinta.getAtk()));
                        textviewDefence.setText("DEF: " + Integer.toString(esivalinta.getDef()));
                        textviewSpecial.setText("Special: " + esivalinta.getSpecial());
                        break;
                    case 3:

                        esivalinta = new Pink("", true);
                        imgLutemon.setImageResource(esivalinta.getImgFront());
                        textviewHP.setText("HP: " + Integer.toString(esivalinta.getHP()));

                        textviewAttack.setText("ATT: " + Integer.toString(esivalinta.getAtk()));
                        textviewDefence.setText("DEF: " + Integer.toString(esivalinta.getDef()));
                        textviewSpecial.setText("Special: " + esivalinta.getSpecial());
                        break;
                    case 4:

                        esivalinta = new Rainbow("", true);
                        imgLutemon.setImageResource(esivalinta.getImgFront());
                        textviewHP.setText("HP: " + Integer.toString(esivalinta.getHP()));

                        textviewAttack.setText("ATT: " + Integer.toString(esivalinta.getAtk()));
                        textviewDefence.setText("DEF: " + Integer.toString(esivalinta.getDef()));
                        textviewSpecial.setText("Special: " + esivalinta.getSpecial());
                        break;
                    default:

                }
                btnCreateLutemon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Boolean HC;
                        if (cb.isChecked()) {
                            HC = true;
                        }
                        else { HC = false;
                        }

                        String name = TextviewName.getText().toString();


                        String color = spinnerLutemons.getSelectedItem().toString();
                        //Lutemon newLutemon = new Lutemon(Name, color, 0, HC);
                        Lutemon newLutemon;
                        switch (color){
                            case ("Gray"):
                                newLutemon = new Gray(name,HC);
                                break;
                            case ("Green"):
                                newLutemon = new Green(name,HC);
                                break;
                            case ("Orange"):
                                newLutemon = new Orange(name,HC);
                                break;
                            case ("Pink"):
                                newLutemon = new Pink(name,HC);
                                break;
                            case ("Rainbow"):
                                newLutemon = new Rainbow(name,HC);
                                break;
                            default:
                                newLutemon = new Pixeli(name,HC);
                                break;
                        }
                        Storage.getInstance().addLutemon(newLutemon);
                        CollectionFragment.refresh();

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}

