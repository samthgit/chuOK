package com.chuok.backend.service;

import com.chuok.backend.model.Level;
import com.chuok.backend.repository.LevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {
    private final LevelRepository levelRepository;

    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
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
}
