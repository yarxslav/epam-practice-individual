package com.epam.task;

public class View {
    private static View instance;

    public static final String INPUT_DATA = "Please, input your number in such interval ";
    public static final String WIN = "Winner-winner chicken dinner. The number was: ";
    public static final String ATTEMPTS = "Your attempts were: ";

    public static final String INPUT_TYPE_INCORRECT = "The type of input is incorrect. Try again. ";
    public static final String OUT_OF_INTERVAL_MIN = "Entered number cannot be less than ";
    public static final String OUT_OF_INTERVAL_MAX = "Entered number cannot be greater than ";

    private View(){}

    public static View getInstance() {
        if(instance == null){
            instance = new View();
        }
        return instance;
    }

    public void printMessage (String message){
        System.out.println(message);
    }

}
