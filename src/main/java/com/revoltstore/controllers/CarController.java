package com.revoltstore.controllers;

import com.revoltstore.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/cars")
    public String getAllCars(Model model,
                             @RequestParam(name = "orderBy", required = false, defaultValue = "1") int orderBy,
                             @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction) {
        model.addAttribute("items", carService.getAllCars(orderBy, direction));
        model.addAttribute("info", "Viewing all cars in the store.");
        model.addAttribute("filterWindow", carService.getFilterWindow());
        model.addAttribute("orderBy", carService.getOrderBy(orderBy, direction));

        return "shop";
    }

}
