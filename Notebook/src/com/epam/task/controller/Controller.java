package com.epam.task.controller;

import com.epam.task.entities.Note;
import com.epam.task.model.NotebookModel;
import com.epam.task.view.View;

import java.util.Locale;
import java.util.Scanner;

public class Controller {
    private static Controller instance;
    private Scanner in = new Scanner(System.in);

    private Controller(){

    }

    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public void execute(){
        View.printMessage(View.START);
        while(!in.nextLine().toLowerCase(Locale.ROOT).equals("enough")){
            NotebookModel notebookModel = new NotebookModel();
            NoteCreator nc = new NoteCreator();
            Note note = nc.createNote();
            if(note == null){
                View.printMessage(View.WRONG_INPUT);
                continue;
            } else {
                notebookModel.addNote(note);
                View.printMessage(View.OK);
            }
        }
    }

}
