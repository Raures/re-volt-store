package com.revoltstore.auxiliary.items;

public enum ShopItemType {

    CAR(1),
    TRACK(2);

    private final int value;

    ShopItemType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
