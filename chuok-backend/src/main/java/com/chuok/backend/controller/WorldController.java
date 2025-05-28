package com.chuok.backend.controller;

import com.chuok.backend.model.World;
import com.chuok.backend.service.WorldService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worlds")
@CrossOrigin(origins = "*")
public class WorldController {
    private final WorldService worldService;

    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    // GET - List all worlds
    @GetMapping
    public List<World> getAllWorlds() {
        return worldService.getAllWorlds();
    }

    // GET - Obtain world by ID
    @GetMapping("/{id}")
    public World getWorldById(@PathVariable Long id) {
        return worldService.getWorldById(id);
    }

    // POST - Create new world
    @PostMapping
    public World createWorld(@Valid @RequestBody World world) {
        return worldService.createWorld(world);
    }

    // PUT - Update existing world
    @PutMapping("/{id}")
    public World updateWorld(@PathVariable Long id, @Valid @RequestBody World updated) {
        return worldService.updateWorld(id, updated);
    }

    // DELETE - Delete world by ID
    @DeleteMapping("/{id}")
    public void deleteWorld(@PathVariable Long id) {
        worldService.deleteWorld(id);
    }
}
