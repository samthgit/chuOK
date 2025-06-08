package com.chuok.backend.controller;

import com.chuok.backend.model.CompletedLevel;
import com.chuok.backend.service.CompletedLevelService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing CompletedLevel entities.
 * Provides endpoints for CRUD operations on completed levels.
 */
@RestController
@RequestMapping("/api/completed-levels")
@CrossOrigin(origins = "*")
public class CompletedLevelController {
    /** Service for completed level business logic. */
    private final CompletedLevelService completedLevelService;

    /**
     * Constructor for dependency injection.
     * @param completedLevelService the CompletedLevelService instance
     */
    public CompletedLevelController(CompletedLevelService completedLevelService) {
        this.completedLevelService = completedLevelService;
    }

    /**
     * GET /api/completed-levels - List all completed levels.
     * @return list of all CompletedLevel entities
     */
    @GetMapping
    public List<CompletedLevel> getAllCompletedLevels() {
        return completedLevelService.getAllCompletedLevels();
    }

    /**
     * GET /api/completed-levels/{id} - Get a completed level by ID.
     * @param id the completed level ID
     * @return the CompletedLevel entity
     */
    @GetMapping("/{id}")
    public CompletedLevel getCompletedLevelById(@PathVariable Long id) {
        return completedLevelService.getCompletedLevelById(id);
    }

    /**
     * POST /api/completed-levels - Create a new completed level.
     * @param completedLevel the CompletedLevel to create
     * @return the created CompletedLevel
     */
    @PostMapping
    public CompletedLevel createCompletedLevel(@Valid @RequestBody CompletedLevel completedLevel) {
        return completedLevelService.createCompletedLevel(completedLevel);
    }

    /**
     * PUT /api/completed-levels/{id} - Update an existing completed level.
     * @param id the completed level ID
     * @param updated the updated CompletedLevel data
     * @return the updated CompletedLevel
     */
    @PutMapping("/{id}")
    public CompletedLevel updateCompletedLevel(@PathVariable Long id, @Valid @RequestBody CompletedLevel updated) {
        return completedLevelService.updateCompletedLevel(id, updated);
    }

    /**
     * DELETE /api/completed-levels/{id} - Delete a completed level by ID.
     * @param id the completed level ID
     */
    @DeleteMapping("/{id}")
    public void deleteCompletedLevel(@PathVariable Long id) {
        completedLevelService.deleteCompletedLevel(id);
    }
}
