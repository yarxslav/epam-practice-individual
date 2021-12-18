package com.epam.task.view;

public class View {
    public static final String ENTER_INT_DATA = "Please, enter as a number: ";
    public static final String ENTER_STRING_DATA = "Please, enter as a string: ";
    public static final String SURNAME = "person's surname.";
    public static final String NAME = "person's name.";
    public static final String PATRONYMIC = "person's patronymic.";
    public static final String INDEX = " address index";
    public static final String CITY = " address city";
    public static final String STREET = " address street";
    public static final String HOUSE_NUMBER = " number of house";
    public static final String APARTMENT_NUMBER = " number of apartment";
    public static final String NICKNAME = "person's nickname";
    public static final String EMAIL = "person's email";
    public static final String GROUP = "person's group";
    public static final String HOME_PHONE_NUMBER = "person's home phone number";
    public static final String PHONE_NUMBER = "person's phone number";
    public static final String ADDITIONAL_PHONE_NUMBER = "person's additional phone number";
    public static final String COMMENT = "comment about this person";
    public static final String WRONG_INPUT = "There was some wrong input.\nPress ENTER to try again.";
    public static final String START = "Enter data to add new notes." +
            "\nIf it's enough for adding type \"enough\"" +
            "\nPress ENTER to start.";
    public static final String OK = "New note added.\nPress ENTER to add one more note or type \"enough\" to finish";
    public static void printMessage(String message){
        System.out.println(message);
    }
}
