package com.example.demo.services;

import com.example.demo.Checkbox;
import com.example.demo.FilterOption;
import com.example.demo.FilterView;
import com.example.demo.FilterWindow;
import com.example.demo.models.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarsService {

    private final CarRepository carRepository;

    public CarsService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(int orderBy, String direction) {
        return carRepository.findAll(Sort.by(Sort.Direction.fromString(direction), ColumnNameMapper.getValue(orderBy)));
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
