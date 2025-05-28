package com.chuok.backend.controller;

import com.chuok.backend.model.CompletedLevel;
import com.chuok.backend.service.CompletedLevelService;
import jakarta.validation.Valid;
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

    // GET - List all completed levels
    @GetMapping
    public List<CompletedLevel> getAllCompletedLevels() {
        return completedLevelService.getAllCompletedLevels();
    }

    // GET - Obtain completed levels by ID
    @GetMapping("/{id}")
    public CompletedLevel getCompletedLevelById(@PathVariable Long id) {
        return completedLevelService.getCompletedLevelById(id);
    }

    // POST - Create completed level
    @PostMapping
    public CompletedLevel createCompletedLevel(@Valid @RequestBody CompletedLevel completedLevel) {
        return completedLevelService.createCompletedLevel(completedLevel);
    }

    // PUT - Update existing completed level
    @PutMapping("/{id}")
    public CompletedLevel updateCompletedLevel(@PathVariable Long id, @Valid @RequestBody CompletedLevel updated) {
        return completedLevelService.updateCompletedLevel(id, updated);
    }

    // DELETE - Delete completed level by ID
    @DeleteMapping("/{id}")
    public void deleteCompletedLevel(@PathVariable Long id) {
        completedLevelService.deleteCompletedLevel(id);
    }
}
