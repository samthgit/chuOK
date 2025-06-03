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

@Service
public class LevelService {
    private final LevelRepository levelRepository;
    private final UserRepository userRepository;
    private final CompletedLevelRepository completedLevelRepository;

    public LevelService(LevelRepository levelRepository,
                        UserRepository userRepository,
                        CompletedLevelRepository completedLevelRepository) {
        this.levelRepository = levelRepository;
        this.userRepository = userRepository;
        this.completedLevelRepository = completedLevelRepository;
    }

    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }

    public Level getLevelById(Long id) {
        return levelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Level not found with id " + id));
    }

    public Level createLevel(Level level) {
        return levelRepository.save(level);
    }

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

    public void deleteLevel(Long id) {
        levelRepository.deleteById(id);
    }

    public List<Level> findByWorldId(Long worldId) {
        return levelRepository.findByWorld_Id(worldId);
    }

    @Transactional
    public List<Level> getCompletedLevels(String email) {
        return completedLevelRepository.findCompletedLevelsByUserEmail(email);
    }

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


}
