package com.example.teamrocketlutemongame;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.Button;

public class ColorTheme {

    public ColorTheme(){
    }

    public ColorStateList SetColor(Button button){
        ColorStateList color = ColorStateList.valueOf(Color.RED);
        return color;
    }
}
