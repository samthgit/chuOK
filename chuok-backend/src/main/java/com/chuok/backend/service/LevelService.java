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
}
