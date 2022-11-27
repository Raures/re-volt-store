package com.example.demo.controllers;

import com.example.demo.repository.CarRepository;
import com.example.demo.repository.EngineRepository;
import com.example.demo.repository.RatingRepository;
import com.example.demo.services.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {
    private final CarRepository carRepository;
    private final EngineRepository engineRepository;
    private final RatingRepository ratingRepository;
    private final StoreService storeService;

    public StoreController(CarRepository carRepository,
                           EngineRepository engineRepository,
                           RatingRepository ratingRepository,
                           StoreService storeService) {
        this.carRepository = carRepository;
        this.engineRepository = engineRepository;
        this.ratingRepository = ratingRepository;
        this.storeService = storeService;
    }

    @GetMapping("/allCars")
    public String getAllCars(Model model) {

        model.addAttribute("cars", storeService.getCars());
        model.addAttribute("engines", engineRepository.findAll());
        model.addAttribute("ratings", ratingRepository.findAll());
        model.addAttribute("enginesCounter", storeService.countEngines());
        model.addAttribute("ratingsCounter", storeService.countRatings());

        return "store_test";
    }
}
