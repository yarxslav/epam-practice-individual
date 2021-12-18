package com.epam.task.entities;

import java.util.ArrayList;

public class Notebook {
    private static Notebook instance;
    private ArrayList<Note> notes = new ArrayList<>();

    private Notebook(){ }

    public static Notebook getInstance(){
        if(instance == null){
            instance = new Notebook();
        }
        return instance;
    }

    public ArrayList<Note> getNotes(){
        return instance.notes;
    }

}
