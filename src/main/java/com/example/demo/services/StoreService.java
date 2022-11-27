package com.example.demo.services;

import com.example.demo.models.Car;
import com.example.demo.models.Engine;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.EngineRepository;
import com.example.demo.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StoreService {

    private final CarRepository carRepository;
    private final EngineRepository engineRepository;
    private final RatingRepository ratingRepository;

    public StoreService(CarRepository carRepository,
                        EngineRepository engineRepository,
                        RatingRepository ratingRepository) {
        this.carRepository = carRepository;
        this.engineRepository = engineRepository;
        this.ratingRepository = ratingRepository;
    }

    public List<Car> getCars() {

        return carRepository.findAll();
    }

    public HashMap<String, Integer> countEngines() {

        HashMap<String, Integer> countedEngines = new HashMap<>();

        for(Car c : carRepository.findAll()) {
            countedEngines.merge(c.getEngine().getType(), 1, Integer::sum);
        }

        return countedEngines;
    }

    public HashMap<String, Integer> countRatings() {

        HashMap<String, Integer> countedRatings = new HashMap<>();

        for(Car c : carRepository.findAll()) {
            countedRatings.merge(c.getRating().getType(), 1, Integer::sum);
        }

        return countedRatings;
    }
}
