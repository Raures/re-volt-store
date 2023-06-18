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

    private final CarService carService;
    private final TrackService trackService;

    public List<ShopItem> getAllWishlistedItems() {
        List<Car> cars = carService.getAllWishlisted();
        List<Track> tracks = trackService.getAllWishlisted();
        List<ShopItem> items = new ArrayList<>();
        items.addAll(Transformer.carToShopItem(cars));
        items.addAll(Transformer.trackToShopItem(tracks));
        return items;
    }

    public void updateItem(long id, int type) {
        if (type == ShopItemType.CAR.getValue()) {
            carService.updateWishlistedStatusById(id);
        } else if (type == ShopItemType.TRACK.getValue()) {
            trackService.updateWishlistedStatusById(id);
        }
    }
}
