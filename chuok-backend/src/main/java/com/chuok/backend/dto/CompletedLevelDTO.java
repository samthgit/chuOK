package com.chuok.backend.dto;

import com.chuok.backend.model.CompletedLevel;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for representing a completed level.
 * Encapsulates information about a user's completed level, including
 * the completion date, level details, and world name.
 */
public record CompletedLevelDTO(
        /** The unique identifier of the completed level. */
        Long id,
        /** The date when the level was completed. */
        LocalDate completionDate,
        /** The unique identifier of the associated level. */
        Long levelId,
        /** The number of the completed level. */
        int levelNumber,
        /** The name of the world to which the level belongs. */
        String worldName
) {
    /**
     * Creates a CompletedLevelDTO from a CompletedLevel entity.
     * @param cl the CompletedLevel entity
     * @return a new CompletedLevelDTO with data extracted from the entity
     */
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
