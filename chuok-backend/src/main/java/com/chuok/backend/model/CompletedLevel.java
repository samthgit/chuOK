package com.chuok.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Entity representing a record of a completed level by a user.
 * Stores the user, level, and completion date.
 */
@Getter
@Setter
@Entity
@Table(name = "completed_levels")
public class CompletedLevel {

    /** Unique identifier for the completed level record (auto-generated). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The user who completed the level. */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /** The level that was completed. */
    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    /** Date when the level was completed (required, defaults to now). */
    @NotNull(message = "Date required")
    private LocalDate completionDate = LocalDate.now();
}
