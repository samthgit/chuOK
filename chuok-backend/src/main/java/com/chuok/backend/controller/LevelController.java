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

    @GetMapping("/byWorld")
    public ResponseEntity<List<Level>> getLevelsByWorldId(@RequestParam Long worldId) {
        List<Level> levels = levelService.findByWorldId(worldId);
        return ResponseEntity.ok(levels);
    }

    @PostMapping("/{levelId}/complete")
    public ResponseEntity<?> markLevelAsCompleted(
            @PathVariable Long levelId,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        String email = userDetails.getUsername();
        levelService.markLevelAsCompleted(levelId, email);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Level>> getCompletedLevels(
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        String email = userDetails.getUsername();
        List<Level> completedLevels = levelService.getCompletedLevels(email);
        return ResponseEntity.ok(completedLevels);
    }

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
