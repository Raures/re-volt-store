package com.example.demo.layout.filters;

public enum FilterOptionType {
    CHECKBOX("checkbox");

    private final String value;

    FilterOptionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
