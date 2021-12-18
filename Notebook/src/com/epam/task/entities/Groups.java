package com.epam.task.entities;

public enum Groups {
    FAMILY("Family"), WORK("Work"),
    FRIENDS("Friends"), OTHER("Others");

    private String description;
    Groups(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
