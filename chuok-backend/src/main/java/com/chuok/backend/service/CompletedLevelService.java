package com.chuok.backend.service;

import com.chuok.backend.model.CompletedLevel;
import com.chuok.backend.repository.CompletedLevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompletedLevelService {
    private final CompletedLevelRepository completedLevelRepository;

    public CompletedLevelService(CompletedLevelRepository completedLevelRepository) {
        this.completedLevelRepository = completedLevelRepository;
    }

    public List<CompletedLevel> getAllCompletedLevels() {
        return completedLevelRepository.findAll();
    }
}
