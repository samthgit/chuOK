package com.chuok.backend.dto;

import com.chuok.backend.model.CompletedLevel;

import java.time.LocalDate;

public record CompletedLevelDTO(
        Long id,
        LocalDate completionDate,
        Long levelId,
        int levelNumber,
        String worldName
) {
    public static CompletedLevelDTO from(CompletedLevel cl) {
        return new CompletedLevelDTO(
                cl.getId(),
                cl.getCompletionDate(),
                cl.getLevel().getId(),
                cl.getLevel().getLevelNumber(),
                cl.getLevel().getWorld().getName()
        );
    }
}
