package com.epam.task.controller;

import com.epam.task.entities.Address;
import com.epam.task.view.View;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressCreator {
    private Scanner in = new Scanner(System.in);
    private Pattern pattern;
    private Matcher matcher;
    public static final String INDEX_REGEX = "\\d{5}";
    public static final String LETTERS_ONLY_REGEX = "^[A-Z][a-z]+";

    public Address createAddress() {
        View.printMessage(getStringInputMessage(View.INDEX));
        String index = validateAndGetString(in.nextLine(), Parameters.INDEX);
        View.printMessage(getStringInputMessage(View.CITY));
        String city = validateAndGetString(in.nextLine(), Parameters.CITY);
        View.printMessage(getStringInputMessage(View.STREET));
        String street = validateAndGetString(in.nextLine(), Parameters.STREET);
        View.printMessage(getIntInputMessage(View.HOUSE_NUMBER));
        int houseNumber = validateAndGetInt(in.nextInt(), Parameters.HOUSE_NUMBER);
        View.printMessage(getIntInputMessage(View.APARTMENT_NUMBER));
        int apartmentNumber = validateAndGetInt(in.nextInt(), Parameters.APARTMENT_NUMBER);

        if (!(index.equals("-")) && !(city.equals("-")) && !(street.equals("-")) && houseNumber != -1 && apartmentNumber != -1) {
            return new Address(index, city, street, houseNumber, apartmentNumber);
        } else {
            return null;
        }
    }

    private String validateAndGetString(String value, Parameters param) {
        switch (param) {
            case INDEX:
                pattern = Pattern.compile(INDEX_REGEX);
                matcher = pattern.matcher(value);
                return matcher.matches() ? value : "-";
            case CITY:
                pattern = Pattern.compile(LETTERS_ONLY_REGEX);
                matcher = pattern.matcher(value);
                return matcher.matches() ? value : "-";
            case STREET:
                pattern = Pattern.compile(LETTERS_ONLY_REGEX);
                matcher = pattern.matcher(value);
                return matcher.matches() ? value : "-";
            default:
                return "-";
        }
    }

    private int validateAndGetInt(int value, Parameters param) {
        switch (param) {
            case HOUSE_NUMBER, APARTMENT_NUMBER:
                if (value > 0) {
                    return value;
                } else return -1;
            default:
                return -1;
        }
    }

    public String getIntInputMessage(String forWhat) {
        return View.ENTER_INT_DATA + forWhat;
    }

    public String getStringInputMessage(String forWhat) {
        return View.ENTER_STRING_DATA + forWhat;
    }
}
