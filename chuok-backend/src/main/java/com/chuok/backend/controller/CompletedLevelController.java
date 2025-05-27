package com.chuok.backend.controller;

import com.chuok.backend.model.CompletedLevel;
import com.chuok.backend.service.CompletedLevelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/completed-levels")
@CrossOrigin(origins = "*")
public class CompletedLevelController {
    private final CompletedLevelService completedLevelService;

    public CompletedLevelController(CompletedLevelService completedLevelService) {
        this.completedLevelService = completedLevelService;
    }

    @GetMapping
    public List<CompletedLevel> getAllCompletedLevels() {
        return completedLevelService.getAllCompletedLevels();
    }
}
