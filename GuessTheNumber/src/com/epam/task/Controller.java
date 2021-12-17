package com.epam.task;

import java.util.Scanner;

public class Controller {
    private static Controller instance;

    private final Model model;
    public final View view;
    private final Scanner in = new Scanner(System.in);

    private Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public static Controller getInstance(Model model, View view){
        if(instance == null){
            instance = new Controller(model, view);
        }
        return instance;
    }

    public void execute(){
        model.setSecretValue();
        System.out.println(model.getNumberToGuess());

        while (model.checkValue(getUserNumber()));

        view.printMessage(View.WIN + model.getNumberToGuess());
        view.printMessage(View.ATTEMPTS + model.getAttempts());
    }

    private int getUserNumber() {
        int userInput;
        view.printMessage(getInterval());
        while (true) {

            while (!in.hasNextInt()) {
                view.printMessage(View.INPUT_TYPE_INCORRECT + getInterval());
                in.next();
            }

            if ((userInput = in.nextInt()) <= model.getMinBarrier()) {
                view.printMessage(View.OUT_OF_INTERVAL_MIN + model.getMinBarrier());
                continue;
            } else if(userInput >= model.getMaxBarrier()){
                view.printMessage(View.OUT_OF_INTERVAL_MAX + model.getMaxBarrier());
                continue;
            }

            break;
        }
        return userInput;
    }

    private String getInterval() {
        StringBuilder sb = new StringBuilder();
        sb.append(View.INPUT_DATA)
                .append("[" + model.getMinBarrier() + ";" + model.getMaxBarrier() + "]");
        return sb.toString();
    }
}
