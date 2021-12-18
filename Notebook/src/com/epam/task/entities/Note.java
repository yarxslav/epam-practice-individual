package com.epam.task.entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Note {
    private String surname;
    private String name;
    private String patronymic;
    private String nickname;
    private String person;
    private String comment;
    private Groups group;
    private String homePhoneNumber;
    private String phoneNumber;
    private String additionalPhoneNumber;
    private String email;
    private Address address;
    private String fullAddress;
    private LocalDateTime createdAt;
    private LocalDateTime lastChangedAt;

    public Note(String surname, String name, String patronymic, String nickname, String comment,
                Groups group, String homePhoneNumber, String phoneNumber,
                String additionalPhoneNumber, String email,
                Address address) {

        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.nickname = nickname;
        this.person = surname + " " + name.substring(0, 1) + ".";
        this.comment = comment;
        this.group = group;
        this.homePhoneNumber = homePhoneNumber;
        this.phoneNumber = phoneNumber;
        this.additionalPhoneNumber = additionalPhoneNumber;
        this.email = email;
        this.address = address;
        this.fullAddress = address.toString();
        this.createdAt = LocalDateTime.now();
        this.lastChangedAt = LocalDateTime.now();
    }

    public void setSurname(String surname) {
        this.surname = surname;
        lastChangedAt = LocalDateTime.now();
    }

    public void setName(String name) {
        this.name = name;
        lastChangedAt = LocalDateTime.now();
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        lastChangedAt = LocalDateTime.now();
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
        lastChangedAt = LocalDateTime.now();
    }

    public void setPerson(String person) {
        this.person = person;
        lastChangedAt = LocalDateTime.now();
    }

    public void setComment(String comment) {
        this.comment = comment;
        lastChangedAt = LocalDateTime.now();
    }

    public void setGroup(Groups group) {
        this.group = group;
        lastChangedAt = LocalDateTime.now();
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
        lastChangedAt = LocalDateTime.now();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        lastChangedAt = LocalDateTime.now();
    }

    public void setAdditionalPhoneNumber(String additionalPhoneNumber) {
        this.additionalPhoneNumber = additionalPhoneNumber;
        lastChangedAt = LocalDateTime.now();
    }

    public void setEmail(String email) {
        this.email = email;
        lastChangedAt = LocalDateTime.now();
    }

    public void setAddress(Address address) {
        this.address = address;
        lastChangedAt = LocalDateTime.now();
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
        lastChangedAt = LocalDateTime.now();
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPerson() {
        return person;
    }

    public String getComment() {
        return comment;
    }

    public Groups getGroup() {
        return group;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAdditionalPhoneNumber() {
        return additionalPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address.toString();
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastChangedAt() {
        return lastChangedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note = (Note) o;
        return Objects.equals(surname, note.surname) && Objects.equals(name, note.name) && Objects.equals(patronymic, note.patronymic) && Objects.equals(nickname, note.nickname) && Objects.equals(person, note.person) && Objects.equals(comment, note.comment) && group == note.group && Objects.equals(homePhoneNumber, note.homePhoneNumber) && Objects.equals(phoneNumber, note.phoneNumber) && Objects.equals(additionalPhoneNumber, note.additionalPhoneNumber) && Objects.equals(email, note.email) && Objects.equals(address, note.address) && Objects.equals(fullAddress, note.fullAddress) && Objects.equals(createdAt, note.createdAt) && Objects.equals(lastChangedAt, note.lastChangedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, nickname, person, comment, group, homePhoneNumber, phoneNumber, additionalPhoneNumber, email, address, fullAddress, createdAt, lastChangedAt);
    }

    @Override
    public String toString() {
        return surname + " " + name.substring(0, 1) + ".";
    }
}
