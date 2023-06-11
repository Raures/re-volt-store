package com.example.demo;

public enum OrderOption {

    ID(1, "Id"),
    PRICE(2, "Price"),
    NAME(3, "Name"),
    ENGINE(4, "Engine type"),
    RATING(5, "Rating"),
    SPEED(6, "Speed"),
    ACC(7, "Acceleration"),
    MASS(8, "Mass"),
    DIFF(9, "Difficulty"),
    LEN(10, "Length");

    private final int key;
    private final String value;
    OrderOption(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
