package com.example.demo;


public class ShopItemCharacteristic {
    private final String name;
    private final String type;
    private String additional = "";

    public ShopItemCharacteristic(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public ShopItemCharacteristic(String name, String type, String additional) {
        this.name = name;
        this.type = type;
        this.additional = additional;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        if (!additional.isEmpty()) {
            return type + " " + additional;
        } else {
            return type;
        }
    }
}
