package com.example.teamrocketlutemongame;

import java.io.Serializable;

public abstract class Specs implements Serializable {
    public String name = "pekka";
    public int wins = 0;
    public int losses = 0;



    public int trainingDays = 0;

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
    public int getTrainingDays() {
        return trainingDays;
    }

    public void setTrainingDays() {
        trainingDays += 1;
    }
}
