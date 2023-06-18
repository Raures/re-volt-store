package com.revoltstore.services;

import com.revoltstore.auxiliary.ColumnNameMapper;
import com.revoltstore.auxiliary.Transformer;
import com.revoltstore.layout.filters.Checkbox;
import com.revoltstore.layout.filters.FilterOption;
import com.revoltstore.layout.filters.FilterView;
import com.revoltstore.layout.filters.FilterWindow;
import com.revoltstore.auxiliary.items.ShopItem;
import com.revoltstore.layout.order.OrderBy;
import com.revoltstore.layout.order.OrderOption;
import com.revoltstore.models.Car;
import com.revoltstore.repository.CarRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<ShopItem> getAllCars(int orderBy, String direction) {
        List<Car> cars = carRepository.findAll(Sort.by(Sort.Direction.fromString(direction), ColumnNameMapper.getValue(orderBy)));
        return new ArrayList<>(Transformer.carToShopItem(cars));
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
        for (Car car : carRepository.findAll()) {
            engines.merge(car.getEngine().getType(), 1, Integer::sum);
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
