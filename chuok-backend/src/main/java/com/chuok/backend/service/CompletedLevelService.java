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

    public CompletedLevel getCompletedLevelById(Long id) {
        return completedLevelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Completed level not found with id " + id));
    }

    public CompletedLevel createCompletedLevel(CompletedLevel cl) {
        return completedLevelRepository.save(cl);
    }

    public CompletedLevel updateCompletedLevel(Long id, CompletedLevel updated) {
        CompletedLevel existing = getCompletedLevelById(id);
        existing.setDate(updated.getDate());
        existing.setUser(updated.getUser());
        existing.setLevel(updated.getLevel());
        return completedLevelRepository.save(existing);
    }

    public void deleteCompletedLevel(Long id) {
        completedLevelRepository.deleteById(id);
    }
}
