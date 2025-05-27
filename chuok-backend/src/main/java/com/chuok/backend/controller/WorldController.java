package com.chuok.backend.controller;

import com.chuok.backend.model.World;
import com.chuok.backend.service.WorldService;
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

    @GetMapping
    public List<World> getAllWorlds() {
        return worldService.getAllWorlds();
    }
}
