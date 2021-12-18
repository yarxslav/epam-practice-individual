package com.epam.task.model;

import com.epam.task.entities.*;

public class NotebookModel {

    private Notebook notebook = Notebook.getInstance();

    public void addNote(Note note){
        notebook.getNotes().add(note);
    }

    public String allNotes(){
        StringBuilder sb = new StringBuilder();
        for (Note note : notebook.getNotes()) {
            sb.append(note.toString() + "\n");
        }
        return sb.toString();
    }

}
