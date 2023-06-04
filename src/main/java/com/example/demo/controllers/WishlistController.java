package com.example.demo.controllers;

import com.example.demo.services.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

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
        carsService.updateWishlistedStatusById(id);
        return "redirect:/cars";
    }

    @PostMapping("/wishlist/remove/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String removeFromWishlistById(@PathVariable Long id) {
        carsService.updateWishlistedStatusById(id);
        return "redirect:/cars";
    }

}
