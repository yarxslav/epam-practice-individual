package com.epam.task;

public class Main {

    public static void main(String[] args) {

        Controller controller = Controller.getInstance(Model.getInstance(), View.getInstance());
        controller.execute();

    }
}
