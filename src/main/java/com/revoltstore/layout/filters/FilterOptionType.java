package com.revoltstore.layout.filters;

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
