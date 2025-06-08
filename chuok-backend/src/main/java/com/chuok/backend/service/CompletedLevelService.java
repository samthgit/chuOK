package com.chuok.backend.service;

import com.chuok.backend.model.CompletedLevel;
import com.chuok.backend.repository.CompletedLevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing CompletedLevel entities.
 * Provides methods for CRUD operations on completed levels.
 */
@Service
public class CompletedLevelService {
    /** Repository for accessing CompletedLevel data. */
    private final CompletedLevelRepository completedLevelRepository;

    /**
     * Constructor for dependency injection.
     * @param completedLevelRepository the CompletedLevelRepository instance
     */
    public CompletedLevelService(CompletedLevelRepository completedLevelRepository) {
        this.completedLevelRepository = completedLevelRepository;
    }

    /**
     * Retrieves all completed levels from the database.
     * @return list of all completed levels
     */
    public List<CompletedLevel> getAllCompletedLevels() {
        return completedLevelRepository.findAll();
    }

    /**
     * Retrieves a single completed level by its ID.
     * @param id the completed level ID
     * @return the CompletedLevel if found
     * @throws RuntimeException if not found
     */
    public CompletedLevel getCompletedLevelById(Long id) {
        return completedLevelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Completed level not found with id " + id));
    }

    /**
     * Creates a new completed level record in the database.
     * @param cl the CompletedLevel to create
     * @return the saved CompletedLevel
     */
    public CompletedLevel createCompletedLevel(CompletedLevel cl) {
        return completedLevelRepository.save(cl);
    }

    /**
     * Updates an existing completed level by ID.
     * @param id the completed level ID
     * @param updated the updated CompletedLevel data
     * @return the updated CompletedLevel
     */
    public CompletedLevel updateCompletedLevel(Long id, CompletedLevel updated) {
        CompletedLevel existing = getCompletedLevelById(id);
        existing.setCompletionDate(updated.getCompletionDate());
        existing.setUser(updated.getUser());
        existing.setLevel(updated.getLevel());
        return completedLevelRepository.save(existing);
    }

    /**
     * Deletes a completed level by its ID.
     * @param id the completed level ID
     */
    public void deleteCompletedLevel(Long id) {
        completedLevelRepository.deleteById(id);
    }
}
