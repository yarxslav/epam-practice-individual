package com.epam.task.exception;

public class NotAvailableNicknameException extends Exception {

    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public NotAvailableNicknameException(String message, String nickname) {
        super(message);
        this.nickname = nickname;
    }
}
