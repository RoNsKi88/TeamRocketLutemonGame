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
import com.example.teamrocketlutemongame.R;
import com.example.teamrocketlutemongame.Storage;


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




        spinnerLutemons.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:

                        imgLutemon.setImageResource(R.drawable.gray_front);
                        textviewHP.setText("HP: 30");
                        textviewAttack.setText("ATT: 5");
                        textviewDefence.setText("DEF: 0");
                        textviewSpecial.setText("Special: RollExtreDef");
                        break;
                    case 1:

                        imgLutemon.setImageResource(R.drawable.green_front);
                        textviewHP.setText("HP: 20");
                        textviewAttack.setText("ATT: 5");
                        textviewDefence.setText("DEF: 10");
                        textviewSpecial.setText("IgnoreDmg");
                        break;
                    case 2:

                        imgLutemon.setImageResource(R.drawable.orange_front);
                        textviewHP.setText("HP: 20");
                        textviewAttack.setText("ATT: 15");
                        textviewDefence.setText("DEF: 0");
                        textviewSpecial.setText("Special: CritHitChange");
                        break;
                    case 3:

                        imgLutemon.setImageResource(R.drawable.pink_front);
                        textviewHP.setText("HP: 25");
                        textviewAttack.setText("ATT: 7");
                        textviewDefence.setText("DEF: 2");
                        textviewSpecial.setText("Special: Leech");
                        break;
                    case 4:

                        imgLutemon.setImageResource(R.drawable.rain_front);
                        textviewHP.setText("HP: 30");
                        textviewAttack.setText("ATT: 15");
                        textviewDefence.setText("DEF: -10");
                        textviewSpecial.setText("Nothing");
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

                        String Name = TextviewName.getText().toString();

                        String Color = spinnerLutemons.getSelectedItem().toString();
                        System.out.println(Color);
                        Lutemon Uusi = new Lutemon(Name, Color, 0, HC);
                        Storage.getInstance().addLutemon(Uusi);
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

