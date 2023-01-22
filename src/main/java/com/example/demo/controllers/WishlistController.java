package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.services.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WishlistController {

    private final CarsService carsService;

    @GetMapping("/wishlist")
    public String viewAllWishlistItems(Model model) {

        model.addAttribute("cars", carsService.getAllWishlisted());

        return "wishlist";
    }

    @PostMapping("/wishlist/add/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String addToWishlistById(@PathVariable Long id) {
        System.out.println("Updated Car with id " + id);

        carsService.updateWishlistedStatusById(id);

        return "redirect:/cars";
    }

    @PostMapping("/wishlist/remove/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String removeFromWishlistById(@PathVariable Long id) {
        System.out.println("Updated Car with id " + id);

        carsService.updateWishlistedStatusById(id);

        return "redirect:/cars";
    }

}
