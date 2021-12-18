package com.epam.task;

import com.epam.task.controller.Controller;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        try {
            Controller controller = Controller.getInstance();
            controller.execute();
        } catch (InputMismatchException e){
            System.out.println("Something went wrong. Try to reload!");
        }


    }

}
