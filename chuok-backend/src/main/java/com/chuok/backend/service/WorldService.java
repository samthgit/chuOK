package com.chuok.backend.service;

import com.chuok.backend.model.World;
import com.chuok.backend.repository.WorldRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing World entities.
 * Provides methods for CRUD operations on worlds.
 */
@Service
public class WorldService {
    /** Repository for accessing World data. */
    private final WorldRepository worldRepository;

    /**
     * Constructor for dependency injection.
     * @param worldRepository the WorldRepository instance
     */
    public WorldService(WorldRepository worldRepository) {
        this.worldRepository = worldRepository;
    }

    /**
     * Retrieves all worlds from the database.
     * @return list of all worlds
     */
    public List<World> getAllWorlds() {
        return worldRepository.findAll();
    }

    /**
     * Retrieves a single world by its ID.
     * @param id the world ID
     * @return the World if found
     * @throws RuntimeException if not found
     */
    public World getWorldById(Long id) {
        return worldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("World not found with id " + id));
    }

    /**
     * Creates a new world in the database.
     * @param world the World to create
     * @return the saved World
     */
    public World createWorld(World world) {
        return worldRepository.save(world);
    }

    /**
     * Updates an existing world by ID.
     * @param id the world ID
     * @param updated the updated World data
     * @return the updated World
     */
    public World updateWorld(Long id, World updated) {
        World existing = getWorldById(id);
        existing.setName(updated.getName());
        existing.setOrderIndex(updated.getOrderIndex());
        return worldRepository.save(existing);
    }

    /**
     * Deletes a world by its ID.
     * @param id the world ID
     */
    public void deleteWorld(Long id) {
        worldRepository.deleteById(id);
    }
}
