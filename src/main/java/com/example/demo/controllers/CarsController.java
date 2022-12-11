package com.example.demo.controllers;

import com.example.demo.repository.CarRepository;
import com.example.demo.repository.EngineRepository;
import com.example.demo.repository.RatingRepository;
import com.example.demo.services.CarsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarsController {
    private final CarRepository carRepository;
    private final EngineRepository engineRepository;
    private final RatingRepository ratingRepository;
    private final CarsService carsService;

    public CarsController(CarRepository carRepository,
                          EngineRepository engineRepository,
                          RatingRepository ratingRepository,
                          CarsService carsService) {
        this.carRepository = carRepository;
        this.engineRepository = engineRepository;
        this.ratingRepository = ratingRepository;
        this.carsService = carsService;
    }

    @GetMapping("/cars")
    public String getAllCars(Model model) {
        model.addAttribute("cars", carsService.getCars());
        model.addAttribute("engines", engineRepository.findAll());
        model.addAttribute("ratings", ratingRepository.findAll());
        model.addAttribute("enginesCounter", carsService.countEngines());
        model.addAttribute("ratingsCounter", carsService.countRatings());

        return "cars";
    }
}
