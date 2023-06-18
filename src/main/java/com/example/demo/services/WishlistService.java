package com.example.demo.services;

import com.example.demo.Transformer;
import com.example.demo.layout.items.ShopItem;
import com.example.demo.layout.items.ShopItemType;
import com.example.demo.models.Car;
import com.example.demo.models.Track;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WishlistService {

    private final CarsService carsService;
    private final TracksService tracksService;

    public List<ShopItem> getAllWishlistedItems() {
        List<Car> cars = carsService.getAllWishlisted();
        List<Track> tracks = tracksService.getAllWishlisted();
        List<ShopItem> items = new ArrayList<>();
        items.addAll(Transformer.carToShopItem(cars));
        items.addAll(Transformer.trackToShopItem(tracks));
        return items;
    }

    public void updateItem(long id, int type) {
        if (type == ShopItemType.CAR.getValue()) {
            carsService.updateWishlistedStatusById(id);
        } else if (type == ShopItemType.TRACK.getValue()) {
            tracksService.updateWishlistedStatusById(id);
        }
    }
}
