package com.epam.task.entities;

import java.util.Objects;

public class Address {
    private String index;
    private String city;
    private String street;
    private int houseNumber;
    private int apartmentNumber;

    public Address(String index, String city, String street, int houseNumber, int apartmentNumber) {
        this.index = index;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "index='" + index + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber && apartmentNumber == address.apartmentNumber && Objects.equals(index, address.index) && Objects.equals(city, address.city) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, city, street, houseNumber, apartmentNumber);
    }
}
