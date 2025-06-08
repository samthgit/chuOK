package com.chuok.backend.controller;

import com.chuok.backend.dto.CompletedLevelDTO;
import com.chuok.backend.model.CompletedLevel;
import com.chuok.backend.model.Level;
import com.chuok.backend.security.CustomUserDetails;
import com.chuok.backend.service.LevelService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Level entities and user progress.
 * Provides endpoints for CRUD operations, marking levels as completed, and retrieving user stats.
 */
@RestController
@RequestMapping("/api/levels")
@CrossOrigin(origins = "*")
public class LevelController {
    /** Service for level-related business logic. */
    private final LevelService levelService;

    /**
     * Constructor for dependency injection.
     * @param levelService the LevelService instance
     */
    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    /**
     * GET /api/levels - List all levels.
     * @return list of all Level entities
     */
    @GetMapping
    public List<Level> getAllLevels() {
        return levelService.getAllLevels();
    }

    /**
     * GET /api/levels/{id} - Get a level by ID.
     * @param id the level ID
     * @return the Level entity
     */
    @GetMapping("/{id}")
    public Level getLevelById(@PathVariable Long id) {
        return levelService.getLevelById(id);
    }

    /**
     * POST /api/levels - Create a new level.
     * @param level the Level to create
     * @return the created Level
     */
    @PostMapping
    public Level createLevel(@Valid @RequestBody Level level) {
        return levelService.createLevel(level);
    }

    /**
     * PUT /api/levels/{id} - Update an existing level.
     * @param id the level ID
     * @param updated the updated Level data
     * @return the updated Level
     */
    @PutMapping("/{id}")
    public Level updateLevel(@PathVariable Long id, @Valid @RequestBody Level updated) {
        return levelService.updateLevel(id, updated);
    }

    /**
     * DELETE /api/levels/{id} - Delete a level by ID.
     * @param id the level ID
     */
    @DeleteMapping("/{id}")
    public void deleteLevel(@PathVariable Long id) {
        levelService.deleteLevel(id);
    }

    /**
     * GET /api/levels/byWorld?worldId= - Get all levels for a specific world.
     * @param worldId the world ID
     * @return list of Level entities in the world
     */
    @GetMapping("/byWorld")
    public ResponseEntity<List<Level>> getLevelsByWorldId(@RequestParam Long worldId) {
        List<Level> levels = levelService.findByWorldId(worldId);
        return ResponseEntity.ok(levels);
    }

    /**
     * POST /api/levels/{levelId}/complete - Mark a level as completed for the authenticated user.
     * @param levelId the level ID
     * @param userDetails the authenticated user's details
     * @return HTTP 200 OK
     */
    @PostMapping("/{levelId}/complete")
    public ResponseEntity<?> markLevelAsCompleted(
            @PathVariable Long levelId,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        String email = userDetails.getUsername();
        levelService.markLevelAsCompleted(levelId, email);
        return ResponseEntity.ok().build();
    }

    /**
     * GET /api/levels/completed - Get all completed levels for the authenticated user.
     * @param userDetails the authenticated user's details
     * @return list of completed Level entities
     */
    @GetMapping("/completed")
    public ResponseEntity<List<Level>> getCompletedLevels(
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        String email = userDetails.getUsername();
        List<Level> completedLevels = levelService.getCompletedLevels(email);
        return ResponseEntity.ok(completedLevels);
    }

    /**
     * GET /api/levels/stats - Get user stats (completed levels) for the authenticated user.
     * @param userDetails the authenticated user's details
     * @return list of CompletedLevelDTOs
     */
    @GetMapping("/stats")
    public ResponseEntity<List<CompletedLevelDTO>> getUserStats(@AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        List<CompletedLevel> completions = levelService.getUserStats(email);

        List<CompletedLevelDTO> dtos = completions.stream()
                .map(CompletedLevelDTO::from)
                .toList();

        return ResponseEntity.ok(dtos);
    }

}
