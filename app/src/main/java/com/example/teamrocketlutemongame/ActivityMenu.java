package com.example.teamrocketlutemongame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class ActivityMenu extends AppCompatActivity {
    private Button btnStartBattle;
    private Battle battle;
    private TabLayout tabLayout;
    private ViewPager2 fragmentArea;
    private TabPageAdapter tabPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tabLayout = findViewById(R.id.menuTabLayout);
        fragmentArea = findViewById(R.id.fragmentShowingArena);
        tabPageAdapter = new TabPageAdapter(this);
        fragmentArea.setAdapter(tabPageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentArea.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                fragmentArea.setCurrentItem(tab.getPosition());
            }
        });
        fragmentArea.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });







        /*btnStartBattle = findViewById(R.id.btnStartBattle);
        btnStartBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                battle.getInstace().setBattle(Storage.getInstance().getPlayer());
                Intent intent = new Intent(ActivityMenu.this,ActivityBattle.class);
                startActivity(intent);
            }
        });

*/
    }
}