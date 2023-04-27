package com.example.teamrocketlutemongame;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.teamrocketlutemongame.Fragments.CollectionFragment;
import com.example.teamrocketlutemongame.Fragments.CreatorFragment;
import com.example.teamrocketlutemongame.Fragments.GraveyardFragment;
import com.example.teamrocketlutemongame.Fragments.MenuFragment;

public class TabPageAdapter extends FragmentStateAdapter {


    public TabPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new MenuFragment();
            case 1:
                return new CollectionFragment();
            case 2:
                return new CreatorFragment();
            case 3:
                return new GraveyardFragment();
            default:
                return new MenuFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
