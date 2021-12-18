package com.epam.task;

import com.epam.task.controller.Controller;
import com.epam.task.exception.NotAvailableNicknameException;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        try {
            Controller controller = Controller.getInstance();
            controller.execute();
        } catch (InputMismatchException ex) {
            System.out.println("Some data was wrong type. Try to reload!");
        } catch (NotAvailableNicknameException e){
            System.out.println(e.getMessage());
        }


    }

}
