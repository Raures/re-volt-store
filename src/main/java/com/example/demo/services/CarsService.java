package com.example.demo.services;

import com.example.demo.models.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.EngineRepository;
import com.example.demo.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarsService {

    private final CarRepository carRepository;

    public CarsService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {

        return carRepository.findAll();
    }

    public HashMap<String, Integer> groupCountEnginesPerType() {

        HashMap<String, Integer> engines = new HashMap<>();

        for(Car c : carRepository.findAll()) {
            engines.merge(c.getEngine().getType(), 1, Integer::sum);
        }

        return engines;
    }

    public HashMap<String, Integer> groupCountRatingsPerType() {

        HashMap<String, Integer> ratings = new HashMap<>();

        for(Car c : carRepository.findAll()) {
            ratings.merge(c.getRating().getType(), 1, Integer::sum);
        }

        return ratings;
    }
}
