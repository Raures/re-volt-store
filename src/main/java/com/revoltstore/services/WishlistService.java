package com.revoltstore.services;

import com.revoltstore.auxiliary.Transformer;
import com.revoltstore.auxiliary.items.ShopItem;
import com.revoltstore.auxiliary.items.ShopItemType;
import com.revoltstore.models.Car;
import com.revoltstore.models.Track;
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
