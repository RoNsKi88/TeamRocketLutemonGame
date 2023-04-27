package com.example.teamrocketlutemongame;

import java.io.Serializable;

public class Specs implements Serializable {
    String name = "pekka";
    int wins = 0;
    int losses = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins() {
        wins += 1;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses() {
        this.losses += 1;
    }
}
