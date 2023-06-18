package com.revoltstore.controllers;

import com.revoltstore.services.WishlistService;
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

    private final WishlistService wishlistService;

    @GetMapping("/wishlist")
    public String viewAllWishlistItems(Model model) {
        model.addAttribute("items", wishlistService.getAllWishlistedItems());
        return "wishlist";
    }

    @PostMapping("/wishlist/update/{type}/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String addToWishlistById(@PathVariable int type, @PathVariable Long id) {
        wishlistService.updateItem(id, type);
//        carsService.updateWishlistedStatusById(id);
        return "redirect:/cars";
    }

}
