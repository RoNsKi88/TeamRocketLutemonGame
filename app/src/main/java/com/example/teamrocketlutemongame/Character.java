package com.example.teamrocketlutemongame;

public class Character extends Specs {
    private String name;
    Lutemon lutemon = null;

    public Character(String name) {
        this.name = name;
    }

    public Lutemon getPlayerLutemon() {
        return lutemon;
    }

    public void setPlayerLutemon(Lutemon lutemon) {
        this.lutemon = lutemon;
    }
}
