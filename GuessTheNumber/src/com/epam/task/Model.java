package com.epam.task;

import java.util.Random;

public class Model {
    private static Model instance;

    private int minBarrier = 0;
    private int maxBarrier = 100;

    private int numberToGuess;

    private StringBuilder attempts = new StringBuilder();

    private Model(){}

    public static Model getInstance(){
        if(instance == null){
            instance = new Model();
        }
        return instance;
    }

    public int getNumberToGuess() {
        return numberToGuess;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public StringBuilder getAttempts() {
        return attempts;
    }

    public void setBarriers(int minBarrier, int maxBarrier){
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
    }

    public void setSecretValue(){
        numberToGuess = new Random().nextInt(minBarrier, maxBarrier);
    }

    public boolean checkValue (int value){
        attempts.append(value).append(" ");

        if (value == numberToGuess){
            return false;
        } else if (value > numberToGuess){
            this.setBarriers(this.minBarrier, value);
        } else {
            this.setBarriers(value, this.maxBarrier);
        }
        return true;
    }

}
