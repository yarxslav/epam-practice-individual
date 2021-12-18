package com.epam.task.controller;

import com.epam.task.entities.Address;
import com.epam.task.entities.Groups;
import com.epam.task.entities.Note;
import com.epam.task.entities.Notebook;
import com.epam.task.exception.NotAvailableNicknameException;
import com.epam.task.model.NotebookModel;
import com.epam.task.view.View;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteCreator {
    private Scanner in = new Scanner(System.in);
    private Pattern pattern;
    private Matcher matcher;
    public static final String NICKNAME_REGEX = "//d{5}";
    public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String HOME_PHONE_REGEX = "^\\+380\\d{9}";
    public static final String PHONE_NUMBER_REGEX = "^\\+380\\d{9}";
    public static final String LETTERS_ONLY_REGEX = "\\b([A-ZА-ЯÀ-ÿ][-,a-zа-я. ']+[ ]*)+";

    public Note createNote() throws NotAvailableNicknameException {
        View.printMessage(getStringInputMessage(View.SURNAME));
        String surname = validateAndGet(in.nextLine(), Parameters.SURNAME);
        View.printMessage(getStringInputMessage(View.NAME));
        String name = validateAndGet(in.nextLine(), Parameters.NAME);
        View.printMessage(getStringInputMessage(View.PATRONYMIC));
        String patronymic = validateAndGet(in.nextLine(), Parameters.PATRONYMIC);
        View.printMessage(getStringInputMessage(View.NICKNAME));
        String nickname = validateAndGet(in.nextLine(), Parameters.NICKNAME);
        View.printMessage(getStringInputMessage(View.COMMENT));
        String comment = validateAndGet(in.nextLine(), Parameters.COMMENT);
        View.printMessage(getStringInputMessage(View.GROUP));
        String group = validateAndGet(in.nextLine().toLowerCase(Locale.ROOT), Parameters.GROUP);
        View.printMessage(getStringInputMessage(View.HOME_PHONE_NUMBER));
        String homePhoneNumber = validateAndGet(in.nextLine(), Parameters.HOME_PHONE_NUMBER);
        View.printMessage(getStringInputMessage(View.PHONE_NUMBER));
        String phoneNumber = validateAndGet(in.nextLine(), Parameters.PHONE_NUMBER);
        View.printMessage(getStringInputMessage(View.ADDITIONAL_PHONE_NUMBER));
        String additionalPhoneNumber = validateAndGet(in.nextLine(), Parameters.ADDITIONAL_PHONE_NUMBER);
        View.printMessage(getStringInputMessage(View.EMAIL));
        String email = validateAndGet(in.nextLine(), Parameters.EMAIL);
        Address address = new AddressCreator().createAddress();

        Groups groupEnum;

        switch (group) {
            case "family":
                groupEnum = Groups.FAMILY;
                break;
            case "work":
                groupEnum = Groups.WORK;
            case "friends":
                groupEnum = Groups.FRIENDS;
            case "other":
                groupEnum = Groups.OTHER;
            default:
                groupEnum = null;
        }

        if (!nicknameAvailable(nickname)) {
            throw new NotAvailableNicknameException("This nickname is already defined. Try again!", nickname);
        } else if (!(surname.equals("-")) && !(name.equals("-")) && !(patronymic.equals("-")) && nickname.equals("-")
                && !(comment.equals(null)) && !(group.equals(null)) && !(homePhoneNumber.equals("-")) && !(phoneNumber.equals("-"))
                && !(additionalPhoneNumber.equals("-")) && !(email.equals("-")) && !(address.equals(null))) {
            return new Note(surname, name, patronymic, nickname, comment, groupEnum, homePhoneNumber, phoneNumber, additionalPhoneNumber, email, address);
        } else {
            return null;
        }
    }

    private String validateAndGet(String value, Parameters param) {
        switch (param) {
            case SURNAME, NAME, PATRONYMIC:
                pattern = Pattern.compile(LETTERS_ONLY_REGEX);
                matcher = pattern.matcher(value);
                return matcher.matches() ? value : "-";
            case NICKNAME:
                pattern = Pattern.compile(NICKNAME_REGEX);
                matcher = pattern.matcher(value);
                return matcher.matches() ? value : "-";
            case GROUP:
                switch (value) {
                    case "family", "friends", "work", "other":
                        return value;
                    default:
                        return "-";
                }
            case HOME_PHONE_NUMBER:
                pattern = Pattern.compile(HOME_PHONE_REGEX);
                matcher = pattern.matcher(value);
                return matcher.matches() ? value : "-";
            case PHONE_NUMBER, ADDITIONAL_PHONE_NUMBER:
                pattern = Pattern.compile(PHONE_NUMBER_REGEX);
                matcher = pattern.matcher(value);
                return matcher.matches() ? value : "-";
            case EMAIL:
                pattern = Pattern.compile(EMAIL_REGEX);
                matcher = pattern.matcher(value);
                return matcher.matches() ? value : "-";
            default:
                return "-";
        }
    }

    public String getStringInputMessage(String forWhat) {
        return View.ENTER_STRING_DATA + forWhat;
    }

    private boolean nicknameAvailable(String nickname) {
        boolean isAvailable = true;
        Notebook notebook = Notebook.getInstance();
        ArrayList<Note> notes = notebook.getNotes();
        for (Note note : notes) {
            if (note.getNickname().equals(nickname)) {
                isAvailable = false;
            }
        }
        return isAvailable;
    }
}
