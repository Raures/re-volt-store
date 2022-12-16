package com.example.demo.controllers;

import com.example.demo.repository.DifficultyRepository;
import com.example.demo.repository.TrackRepository;
import com.example.demo.services.TracksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TracksController {

    private final TracksService tracksService;
    private final DifficultyRepository difficultyRepository;

    public TracksController(TracksService tracksService, DifficultyRepository difficultyRepository) {
        this.tracksService = tracksService;
        this.difficultyRepository = difficultyRepository;
    }

    @GetMapping("/tracks")
    public String getAllTracks(Model model) {
        model.addAttribute("tracks", tracksService.getAllTracks());
        model.addAttribute("difficulties", difficultyRepository.findAll());
        model.addAttribute("difficultiesCounter", tracksService.groupCountDifficultiesByType());

        return "tracks_simpleview";
    }
}
