package com.example.teamrocketlutemongame;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Storage implements Serializable {
    private Character player;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private ArrayList<Lutemon> deadlutemons = new ArrayList<>();
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
        // System.out.println(player);
        this.player = player;
    }

    public ArrayList<Lutemon> getLutemons(){
        return lutemons;
    }

    public ArrayList<Lutemon> getDeadlutemons() {
        return deadlutemons;
    }
    public Lutemon getDeadLutemon(int index){
        return deadlutemons.get(index);
    }

    public Lutemon getLutemon(int index){
        return lutemons.get(index);
    }

    public void addDeadLutemon(Lutemon lutemon) {
        System.out.println("Following Lutemons are lost forever:");
        deadlutemons.add(lutemon);
        for (Lutemon keppana:deadlutemons){
            System.out.println(keppana.getName());
        }
    }

    public void addLutemon(Lutemon lutemon){
        lutemons.add(lutemon);
        System.out.println("Varastossa on tällä hetkellä seuraavat Lutemonit:");

        for (Lutemon keppana:lutemons){
            System.out.println(keppana.getName());
        }
    }
    public void removeLutemon(int index){
        lutemons.remove(index);
    }

    public void saveLutemons(Context context) {
        try {
            ObjectOutputStream LutemonWriter = new ObjectOutputStream(context.openFileOutput("Lutemons.data", Context.MODE_PRIVATE));
            LutemonWriter.writeObject(Storage.getInstance());
            LutemonWriter.close();
            System.out.println("Saving Dada has Succeeded, i thinks!");
        } catch (IOException e) {
            System.out.println("Saving Dada has failed, please contact support for more help.");
        }
    }

    public void loadLutemons(Context context) {
        try {
            ObjectInputStream LutemonReader = new ObjectInputStream(context.openFileInput("Lutemons.data"));
            storage = (Storage) LutemonReader.readObject();

            LutemonReader.close();
            System.out.println("Loadink Dada has Succeeded, i thinks!");
        } catch (FileNotFoundException e) {
            System.out.println("Loading Dada didn't succeed.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Loading Dada didn't succeed.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Loading Dada didn't succeed.");
            e.printStackTrace();
        }
    }
}
