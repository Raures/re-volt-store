package com.example.demo.services;

public enum ColumnNameMapper {

    ID(1, "id"),
    PRICE(2, "price"),
    NAME(3, "name"),
    ENGINE(4, "engine_id"),
    RATING(5, "rating_id"),
    SPEED(6, "speed"),
    ACC(7, "acc"),
    MASS(8, "mass"),
    DIFF(9, "difficulty_id"),
    LEN(10, "length");

    private final int key;
    private final String value;

    ColumnNameMapper(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValue(int key) {
        String value;
        switch (key) {
            case 1 -> value = ID.value;
            case 2 -> value = PRICE.value;
            case 3 -> value = NAME.value;
            case 4 -> value = ENGINE.value;
            case 5 -> value = RATING.value;
            case 6 -> value = SPEED.value;
            case 7 -> value = ACC.value;
            case 8 -> value = MASS.value;
            case 9 -> value = DIFF.value;
            case 10 -> value = LEN.value;
            default -> value = ID.value;
        }
        return value;
    }
}
