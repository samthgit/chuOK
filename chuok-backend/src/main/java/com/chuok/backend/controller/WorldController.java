package com.chuok.backend.controller;

import com.chuok.backend.model.World;
import com.chuok.backend.service.WorldService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing World entities.
 * Provides endpoints for CRUD operations on World resources.
 */
@RestController
@RequestMapping("/api/worlds")
@CrossOrigin(origins = "*")
public class WorldController {
    /** Service for handling World business logic. */
    private final WorldService worldService;

    /**
     * Constructs a WorldController with the given WorldService.
     * @param worldService the service to handle World operations
     */
    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    /**
     * Retrieves a list of all worlds.
     * @return list of World entities
     */
    @GetMapping
    public List<World> getAllWorlds() {
        return worldService.getAllWorlds();
    }

    /**
     * Retrieves a world by its ID.
     * @param id the ID of the world
     * @return the World entity with the given ID
     */
    @GetMapping("/{id}")
    public World getWorldById(@PathVariable Long id) {
        return worldService.getWorldById(id);
    }

    /**
     * Creates a new world.
     * @param world the World entity to create
     * @return the created World entity
     */
    @PostMapping
    public World createWorld(@Valid @RequestBody World world) {
        return worldService.createWorld(world);
    }

    /**
     * Updates an existing world by ID.
     * @param id the ID of the world to update
     * @param updated the updated World entity
     * @return the updated World entity
     */
    @PutMapping("/{id}")
    public World updateWorld(@PathVariable Long id, @Valid @RequestBody World updated) {
        return worldService.updateWorld(id, updated);
    }

    /**
     * Deletes a world by its ID.
     * @param id the ID of the world to delete
     */
    @DeleteMapping("/{id}")
    public void deleteWorld(@PathVariable Long id) {
        worldService.deleteWorld(id);
    }
}
