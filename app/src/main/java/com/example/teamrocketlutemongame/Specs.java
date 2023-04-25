package com.example.teamrocketlutemongame;

public class Specs {
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
        this.wins += 1;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses() {
        this.losses += 1;
    }
}
