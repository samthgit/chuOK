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

    public World getWorldById(Long id) {
        return worldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("World not found with id " + id));
    }

    public World createWorld(World world) {
        return worldRepository.save(world);
    }

    public World updateWorld(Long id, World updated) {
        World existing = getWorldById(id);
        existing.setName(updated.getName());
        existing.setOrderIndex(updated.getOrderIndex());
        return worldRepository.save(existing);
    }

    public void deleteWorld(Long id) {
        worldRepository.deleteById(id);
    }
}
