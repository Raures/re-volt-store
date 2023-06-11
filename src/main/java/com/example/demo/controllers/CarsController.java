package com.example.demo.controllers;

import com.example.demo.services.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CarsController {
    private final CarsService carsService;

    @GetMapping("/cars")
    public String getAllCars(Model model,
                             @RequestParam(name = "orderBy", required = false, defaultValue = "1") int orderBy,
                             @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction) {
        model.addAttribute("items", carsService.getAllCars(orderBy, direction));
        model.addAttribute("orderBy", orderBy);
        model.addAttribute("direction", direction);
        model.addAttribute("info", "Viewing all cars in the store.");
        model.addAttribute("filterWindow", carsService.getFilterWindow());
        model.addAttribute("orderByOptions", carsService.getOrderByOptions());

        return "shop";
    }

}
