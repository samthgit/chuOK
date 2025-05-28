package com.chuok.backend.controller;

import com.chuok.backend.model.Level;
import com.chuok.backend.service.LevelService;
import jakarta.validation.Valid;
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

    // GET - List all levels
    @GetMapping
    public List<Level> getAllLevels() {
        return levelService.getAllLevels();
    }

    // GET - Obtain user by ID
    @GetMapping("/{id}")
    public Level getLevelById(@PathVariable Long id) {
        return levelService.getLevelById(id);
    }

    // POST - Create new level
    @PostMapping
    public Level createLevel(@Valid @RequestBody Level level) {
        return levelService.createLevel(level);
    }

    // PUT - Update existing level
    @PutMapping("/{id}")
    public Level updateLevel(@PathVariable Long id, @Valid @RequestBody Level updated) {
        return levelService.updateLevel(id, updated);
    }

    // DELETE - Delete level by id
    @DeleteMapping("/{id}")
    public void deleteLevel(@PathVariable Long id) {
        levelService.deleteLevel(id);
    }
}
