package com.example.demo.controllers;

import com.example.demo.repository.DifficultyRepository;
import com.example.demo.services.TracksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class TracksController {

    private final TracksService tracksService;
    private final DifficultyRepository difficultyRepository;

    @GetMapping("/tracks")
    public String getAllTracks(Model model,
                               @RequestParam(name = "orderBy", required = false, defaultValue = "1") int orderBy,
                               @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction) {
        model.addAttribute("tracks", tracksService.getAllTracks(orderBy, direction));
        model.addAttribute("orderBy", orderBy);
        model.addAttribute("direction", direction);
        model.addAttribute("difficulties", difficultyRepository.findAll());
        model.addAttribute("difficultiesCounter", tracksService.groupCountDifficultiesByType());

        return "tracks";
    }
}
