package com.example.demo.controllers;

import com.example.demo.repository.EngineRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EngineController {

    private final EngineRepository engineRepository;

    public EngineController(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    @GetMapping("/engines")
    public ResponseEntity getAllEngines() {

        return ResponseEntity.ok(this.engineRepository.findAll());
    }
}
