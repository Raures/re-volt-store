package com.revoltstore.controllers;

import com.revoltstore.services.TrackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class TrackController {

    private final TrackService trackService;

    @GetMapping("/tracks")
    public String getAllTracks(Model model,
                               @RequestParam(name = "orderBy", required = false, defaultValue = "1") int orderBy,
                               @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction) {
        model.addAttribute("items", trackService.getAllTracks(orderBy, direction));
        model.addAttribute("info", "Viewing all tracks in the store.");
        model.addAttribute("filterWindow", trackService.getFilterWindow());
        model.addAttribute("orderBy", trackService.getOrderBy(orderBy, direction));

        return "shop";
    }
}
