package com.example.teamrocketlutemongame.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamrocketlutemongame.R;
import com.example.teamrocketlutemongame.Recyclerview.LutemonRecyclerViewAdapter;
import com.example.teamrocketlutemongame.Recyclerview.PlayerLutemonAdapter;
import com.example.teamrocketlutemongame.Storage;


public class CollectionFragment extends Fragment {

    private LutemonRecyclerViewAdapter adapter;
    private static View view;


    public CollectionFragment() {
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
        view = inflater.inflate(R.layout.fragment_collection, container, false);

        RecyclerView rvLutemons = view.findViewById(R.id.rcvLutemons);
        rvLutemons.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvLutemons.setAdapter(new LutemonRecyclerViewAdapter(view.getContext(), Storage.getInstance().getLutemons()));
        RecyclerView shownLutemon = view.findViewById(R.id.selectedCharacterLutemon);
        shownLutemon.setLayoutManager(new LinearLayoutManager(view.getContext()));
        shownLutemon.setAdapter(new PlayerLutemonAdapter(view.getContext(), Storage.getInstance().getPlayer().getPlayerLutemon()));

        // Inflate the layout for this fragment
        return view;
    }
    @Override
    public void onResume(){
        super.onResume();
        adapter = new LutemonRecyclerViewAdapter(view.getContext(), Storage.getInstance().getLutemons());

    }
    public static void refresh(){
        RecyclerView rvLutemons = view.findViewById(R.id.rcvLutemons);
        rvLutemons.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvLutemons.setAdapter(new LutemonRecyclerViewAdapter(view.getContext(), Storage.getInstance().getLutemons()));
        RecyclerView shownLutemon = view.findViewById(R.id.selectedCharacterLutemon);
        shownLutemon.setLayoutManager(new LinearLayoutManager(view.getContext()));
        shownLutemon.setAdapter(new PlayerLutemonAdapter(view.getContext(), Storage.getInstance().getPlayer().getPlayerLutemon()));
    }

}