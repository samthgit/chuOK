package com.chuok.backend.service;

import com.chuok.backend.model.CompletedLevel;
import com.chuok.backend.model.Level;
import com.chuok.backend.model.User;
import com.chuok.backend.repository.CompletedLevelRepository;
import com.chuok.backend.repository.LevelRepository;
import com.chuok.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Service class for managing Level entities and user progress.
 * Provides methods for CRUD operations, marking levels as completed, and retrieving user stats.
 */
@Service
public class LevelService {
    /** Repository for accessing Level data. */
    private final LevelRepository levelRepository;
    /** Repository for accessing User data. */
    private final UserRepository userRepository;
    /** Repository for accessing CompletedLevel data. */
    private final CompletedLevelRepository completedLevelRepository;

    /**
     * Constructor for dependency injection.
     * @param levelRepository the LevelRepository instance
     * @param userRepository the UserRepository instance
     * @param completedLevelRepository the CompletedLevelRepository instance
     */
    public LevelService(LevelRepository levelRepository,
                        UserRepository userRepository,
                        CompletedLevelRepository completedLevelRepository) {
        this.levelRepository = levelRepository;
        this.userRepository = userRepository;
        this.completedLevelRepository = completedLevelRepository;
    }

    /**
     * Retrieves all levels from the database.
     * @return list of all levels
     */
    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }

    /**
     * Retrieves a single level by its ID.
     * @param id the level ID
     * @return the Level if found
     * @throws RuntimeException if not found
     */
    public Level getLevelById(Long id) {
        return levelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Level not found with id " + id));
    }

    /**
     * Creates a new level in the database.
     * @param level the Level to create
     * @return the saved Level
     */
    public Level createLevel(Level level) {
        return levelRepository.save(level);
    }

    /**
     * Updates an existing level by ID.
     * @param id the level ID
     * @param updated the updated Level data
     * @return the updated Level
     */
    public Level updateLevel(Long id, Level updated) {
        Level existing = getLevelById(id);
        existing.setLevelNumber(updated.getLevelNumber());
        existing.setQuestion(updated.getQuestion());
        existing.setOption1(updated.getOption1());
        existing.setOption2(updated.getOption2());
        existing.setOption3(updated.getOption3());
        existing.setOption4(updated.getOption4());
        existing.setCorrectIndex(updated.getCorrectIndex());
        existing.setWorld(updated.getWorld());
        return levelRepository.save(existing);
    }

    /**
     * Deletes a level by its ID.
     * @param id the level ID
     */
    public void deleteLevel(Long id) {
        levelRepository.deleteById(id);
    }

    /**
     * Finds all levels belonging to a specific world by its ID.
     * @param worldId the world ID
     * @return list of levels in the given world
     */
    public List<Level> findByWorldId(Long worldId) {
        return levelRepository.findByWorld_Id(worldId);
    }

    /**
     * Retrieves all completed levels for a user by email.
     * @param email the user's email
     * @return list of completed Level entities
     */
    @Transactional
    public List<Level> getCompletedLevels(String email) {
        return completedLevelRepository.findCompletedLevelsByUserEmail(email);
    }

    /**
     * Marks a level as completed for a user, if not already completed.
     * @param levelId the level ID
     * @param userEmail the user's email
     */
    public void markLevelAsCompleted(Long levelId, String userEmail) {
        // Check if it's already completed
        boolean alreadyCompleted = completedLevelRepository.existsByUserEmailAndLevelId(userEmail, levelId);
        if (alreadyCompleted) {
            return;
        }

        // Load user and level
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Level level = levelRepository.findById(levelId)
                .orElseThrow(() -> new RuntimeException("Level not found"));

        // Create and save CompletedLevel
        CompletedLevel completed = new CompletedLevel();
        completed.setUser(user);
        completed.setLevel(level);
        completed.setCompletionDate(LocalDate.now());

        completedLevelRepository.save(completed);
    }

    /**
     * Retrieves user stats (completed levels) for a user by email, ordered by completion date descending.
     * @param email the user's email
     * @return list of CompletedLevel entities
     */
    public List<CompletedLevel> getUserStats(String email) {
        return completedLevelRepository.findAllByUserEmailOrderByCompletionDateDesc(email);
    }
}
