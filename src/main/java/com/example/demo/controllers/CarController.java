package com.example.demo.controllers;

import com.example.demo.repository.CarRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public ResponseEntity getAllCars() {

        return ResponseEntity.ok(this.carRepository.findAll());
    }
    // TODO: Fix ambiguous request for {id} and {name}
    @GetMapping("/cars/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Long id) {

        return ResponseEntity.ok(this.carRepository.findById(id));
    }
}
