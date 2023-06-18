package com.revoltstore;

import com.revoltstore.layout.items.ShopItem;
import com.revoltstore.layout.items.ShopItemCharacteristic;
import com.revoltstore.layout.items.ShopItemType;
import com.revoltstore.models.Car;
import com.revoltstore.models.Track;

import java.util.ArrayList;
import java.util.List;

public class Transformer {

    public static List<ShopItem> carToShopItem(List<Car> cars) {
        List<ShopItem> items = new ArrayList<>();
        for (Car car : cars) {
            long id = car.getId();
            int type = ShopItemType.CAR.getValue();
            String thumbnail = "/images/cars/" + car.getThumbnail().getImage();
            String name = car.getName();
            List<ShopItemCharacteristic> itemCharacteristics = new ArrayList<>();
            itemCharacteristics.add(new ShopItemCharacteristic("Engine type", car.getEngine().getType()));
            itemCharacteristics.add(new ShopItemCharacteristic("Rating", car.getRating().getType()));
            itemCharacteristics.add(new ShopItemCharacteristic("Speed", String.valueOf(car.getSpeed()), "mph"));
            itemCharacteristics.add(new ShopItemCharacteristic("Acceleration", String.valueOf(car.getAcc()), "m/s²"));
            itemCharacteristics.add(new ShopItemCharacteristic("Mass", String.valueOf(car.getMass()), "kg"));
            double price = car.getPrice();
            boolean isWishlisted = car.getWishlisted();
            boolean isCarted = car.getCarted();

            items.add(new ShopItem(id, type, thumbnail, name, itemCharacteristics, price, isWishlisted, isCarted));
        }
        return items;
    }

    public static List<ShopItem> trackToShopItem(List<Track> tracks) {
        List<ShopItem> items = new ArrayList<>();
        for (Track track : tracks) {
            long id = track.getId();
            int type = ShopItemType.TRACK.getValue();
            String thumbnail = "/images/tracks/" + track.getThumbnail().getImage();
            String name = track.getName();
            List<ShopItemCharacteristic> itemCharacteristics = new ArrayList<>();
            itemCharacteristics.add(new ShopItemCharacteristic("Difficulty", track.getDifficulty().getDifficulty()));
            itemCharacteristics.add(new ShopItemCharacteristic("Length", String.valueOf(track.getLength()), "(m)"));
            double price = track.getPrice();
            boolean isWishlisted = track.getWishlisted();
            boolean isCarted = false;

            items.add(new ShopItem(id, type, thumbnail, name, itemCharacteristics, price, isWishlisted, isCarted));
        }
        return items;
    }
}
