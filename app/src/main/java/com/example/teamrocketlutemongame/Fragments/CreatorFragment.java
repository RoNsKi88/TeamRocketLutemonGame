package com.example.teamrocketlutemongame.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.teamrocketlutemongame.ActivityMenu;
import com.example.teamrocketlutemongame.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreatorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreatorFragment newInstance(String param1, String param2) {
        CreatorFragment fragment = new CreatorFragment();
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
        View view = inflater.inflate(R.layout.fragment_creator, container, false);
        ImageView imgLutemon = view.findViewById(R.id.imgLutemon);
        imgLutemon.setImageResource(R.drawable.gray_front);
        Spinner spinnerLutemons = view.findViewById(R.id.spinnerLutemons);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),R.array.Lutemons, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLutemons.setAdapter(adapter);
        spinnerLutemons.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        System.out.println("00");
                        imgLutemon.setImageResource(R.drawable.gray_front);

                        break;
                    case 1:
                        System.out.println("1");
                        imgLutemon.setImageResource(R.drawable.green_front);
                        break;
                    case 2:
                        System.out.println("2");
                        imgLutemon.setImageResource(R.drawable.orange_front);
                        break;
                    case 3:
                        System.out.println("3");
                        imgLutemon.setImageResource(R.drawable.pink_front);
                        break;
                    case 4:
                        System.out.println("4");
                        imgLutemon.setImageResource(R.drawable.rain_front);
                        break;
                    default:

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}

