package com.example.demo.services;

import com.example.demo.models.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CarsService {

    private final CarRepository carRepository;

    public CarsService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(int orderBy, String direction) {
        return carRepository.findAll(Sort.by(Sort.Direction.fromString(direction), ColumnNameMapper.getValue(orderBy)));
    }

    public HashMap<String, Integer> groupCountEnginesPerType() {
        HashMap<String, Integer> engines = new HashMap<>();
        for (Car c : carRepository.findAll()) {
            engines.merge(c.getEngine().getType(), 1, Integer::sum);
        }
        return engines;
    }

    public HashMap<String, Integer> groupCountRatingsPerType() {
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
