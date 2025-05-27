package com.chuok.backend.service;

import com.chuok.backend.model.World;
import com.chuok.backend.repository.WorldRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorldService {
    private final WorldRepository worldRepository;

    public WorldService(WorldRepository worldRepository) {
        this.worldRepository = worldRepository;
    }

    public List<World> getAllWorlds() {
        return worldRepository.findAll();
    }
}
