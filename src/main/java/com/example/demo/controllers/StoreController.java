package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.EngineRepository;
import com.example.demo.repository.RatingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreController {
    private final CarRepository carRepository;
    private final EngineRepository engineRepository;
    private final RatingRepository ratingRepository;

    public StoreController(CarRepository carRepository,
                           EngineRepository engineRepository,
                           RatingRepository ratingRepository) {
        this.carRepository = carRepository;
        this.engineRepository = engineRepository;
        this.ratingRepository = ratingRepository;
    }

    @GetMapping("/allCars")
    public String getAllCars(Model model) {

        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("engines", engineRepository.findAll());
        model.addAttribute("ratings", ratingRepository.findAll());

//        List<Car> cs = new ArrayList<>(carRepository.findAll());
//
//        for(Car c: cs) {
//            System.out.println(c.getId() + ". "
//                    + c.getName() + " "
//                    + c.getThumbnail().getImage() + " "
//                    + c.getEngine().getType() + " "
//                    + c.getRating().getType() + " spd: "
//                    + c.getSpeed() + " acc: "
//                    + c.getAcc() + " mass: "
//                    + c.getMass() + ";");
//        }

        return "store_test";
    }
}
