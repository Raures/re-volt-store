package com.example.demo.services;

import com.example.demo.OrderBy;
import com.example.demo.OrderOption;
import com.example.demo.ShopItem;
import com.example.demo.ShopItemCharacteristic;
import com.example.demo.filters.Checkbox;
import com.example.demo.filters.FilterOption;
import com.example.demo.filters.FilterView;
import com.example.demo.filters.FilterWindow;
import com.example.demo.models.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarsService {

    private final CarRepository carRepository;
    private final String[] orderByOptions = new String[] {
            "Id",
            "Price",
            "Name",
            "Engine type",
            "Rating",
            "Speed",
            "Acceleration",
            "Mass"
    };

    public CarsService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<ShopItem> getAllCars(int orderBy, String direction) {
        List<Car> cars = carRepository.findAll(Sort.by(Sort.Direction.fromString(direction), ColumnNameMapper.getValue(orderBy)));
        List<ShopItem> items = new ArrayList<>();
        for (Car car : cars) {
            long id = car.getId();
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

            items.add(new ShopItem(id, thumbnail, name, itemCharacteristics, price, isWishlisted, isCarted));
        }
        return items;
    }

    public FilterWindow getFilterWindow() {
        List<FilterView> filterViewList = new ArrayList<>();
        filterViewList.add(getEngineTypeFilterView());
        filterViewList.add(getRatingFilterView());
        return new FilterWindow("Filters", filterViewList);
    }

    public FilterView getRatingFilterView() {
        List<FilterOption> filterOptions = new ArrayList<>();
        Map<String, Integer> ratings = groupCountRatingsPerType();
        for (Map.Entry<String, Integer> entry : ratings.entrySet()) {
            filterOptions.add(new Checkbox(entry.getKey(), false, entry.getValue()));
        }
        return new FilterView("Ratings", filterOptions);
    }

    public FilterView getEngineTypeFilterView() {
        List<FilterOption> filterOptions = new ArrayList<>();
        Map<String, Integer> engines = groupCountEnginesPerType();
        for (Map.Entry<String, Integer> entry : engines.entrySet()) {
            filterOptions.add(new Checkbox(entry.getKey(), false, entry.getValue()));
        }
        return new FilterView("Engine type", filterOptions);
    }

    public Map<String, Integer> groupCountEnginesPerType() {
        HashMap<String, Integer> engines = new HashMap<>();
        for (Car c : carRepository.findAll()) {
            engines.merge(c.getEngine().getType(), 1, Integer::sum);
        }
        return engines;
    }

    public OrderBy getOrderBy(int orderBy, String direction) {
        List<OrderOption> orderOptions = new ArrayList<>();
        orderOptions.add(OrderOption.ID);
        orderOptions.add(OrderOption.PRICE);
        orderOptions.add(OrderOption.NAME);
        orderOptions.add(OrderOption.ENGINE);
        orderOptions.add(OrderOption.RATING);
        orderOptions.add(OrderOption.SPEED);
        orderOptions.add(OrderOption.ACC);
        orderOptions.add(OrderOption.MASS);
        return new OrderBy(orderBy, orderOptions, direction);
    }

    public Map<String, Integer> groupCountRatingsPerType() {
        HashMap<String, Integer> ratings = new HashMap<>();
        for (Car c : carRepository.findAll()) {
            ratings.merge(c.getRating().getType(), 1, Integer::sum);
        }
        return ratings;
    }

    public void updateWishlistedStatusById(Long id) {
        Boolean wishlistedStatus = carRepository.getWishlistStatus(id);
        carRepository.updateWishlistedStatusById(id, !wishlistedStatus);
    }

    public List<Car> getAllWishlisted() {
        return carRepository.getAllWithWishlistStatus(true);
    }

}
