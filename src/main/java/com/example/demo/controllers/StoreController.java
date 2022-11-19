package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.EngineRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreController {
    private final CarRepository carRepository;

    public StoreController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/allCars")
    public String getAllCars(Model model) {

        model.addAttribute("cars", carRepository.findAll());

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

        return "store";
    }
}
