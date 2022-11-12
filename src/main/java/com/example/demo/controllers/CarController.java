package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    @GetMapping("/cars")
    public String cars() {

        return "cars";
    }
}
