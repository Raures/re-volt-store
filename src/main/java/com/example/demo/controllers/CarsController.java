package com.example.demo.controllers;

import com.example.demo.repository.EngineRepository;
import com.example.demo.repository.RatingRepository;
import com.example.demo.services.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CarsController {
    private final EngineRepository engineRepository;
    private final RatingRepository ratingRepository;
    private final CarsService carsService;

    @GetMapping("/cars")
    public String getAllCars(Model model) {
        model.addAttribute("cars", carsService.getAllCars());
        model.addAttribute("engines", engineRepository.findAll());
        model.addAttribute("ratings", ratingRepository.findAll());
        model.addAttribute("enginesCounter", carsService.groupCountEnginesPerType());
        model.addAttribute("ratingsCounter", carsService.groupCountRatingsPerType());

        return "cars";
    }

    @PostMapping("/cars/order-by")
    public String submit(@RequestParam(value = "criteria") String x) {
        System.out.println("GOT A VALUE - " + x);

        return "cars";
    }
}
