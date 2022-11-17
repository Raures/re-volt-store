package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.EngineRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class StoreController {

//    private ServletContext servletContext;
    private final CarRepository carRepository;
    private final EngineRepository engineRepository;

    public StoreController(CarRepository carRepository, EngineRepository engineRepository) {
        this.carRepository = carRepository;
        this.engineRepository = engineRepository;
    }

    @GetMapping("/allCars")
    public String getAllCars(Model model) {

        model.addAttribute("cars", carRepository.findAll());
//        model.addAttribute("engines", engineRepository.findAll());

        return "store";
    }
}
