package com.example.teamrocketlutemongame;

import java.util.ArrayList;

public class Storage {
    private Character player;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static Storage storage = null;

    private Storage(){

    }
    public static Storage getInstance(){
        if (storage == null){
            storage = new Storage();
        }
        return storage;
    }

    public Character getPlayer(){
        return player;
    }
    public void setPlayer(Character player) {
        System.out.println(player);
        this.player = player;
    }

    public ArrayList<Lutemon> getLutemons(){
        return lutemons;
    }
    public Lutemon getLutemon(int index){
        return lutemons.get(index);
    }
    public void addLutemon(Lutemon lutemon){
        lutemons.add(lutemon);
        for (Lutemon keppana:lutemons){
            System.out.println(keppana.getName());
        }
    }
    public void removeLutemon(int index){
        lutemons.remove(index);
    }
}
