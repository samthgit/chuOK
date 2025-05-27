package com.chuok.backend.controller;

import com.chuok.backend.model.Level;
import com.chuok.backend.service.LevelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
@CrossOrigin(origins = "*")
public class LevelController {
    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping
    public List<Level> getAllLevels() {
        return levelService.getAllLevels();
    }
}
