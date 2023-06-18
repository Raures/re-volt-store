package com.revoltstore.layout.items;


import java.util.List;

public class ShopItem {
    private final long id;
    private final int type;
    private final String thumbnail;
    private final String name;
    private final List<ShopItemCharacteristic> characteristics;
    private final double price;
    private final boolean isWishlisted;
    private final boolean isCarted;

    public ShopItem(long id, int type, String thumbnail, String name, List<ShopItemCharacteristic> characteristics, double price, boolean isWishlisted, boolean isCarted) {
        this.id = id;
        this.type = type;
        this.thumbnail = thumbnail;
        this.name = name;
        this.characteristics = characteristics;
        this.price = price;
        this.isWishlisted = isWishlisted;
        this.isCarted = isCarted;
    }

    public long getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getName() {
        return name;
    }

    public List<ShopItemCharacteristic> getCharacteristics() {
        return characteristics;
    }

    public double getPrice() {
        return price;
    }

    public boolean isWishlisted() {
        return isWishlisted;
    }

    public boolean isCarted() {
        return isCarted;
    }
}
