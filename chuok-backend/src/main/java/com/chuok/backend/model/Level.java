package com.chuok.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a challenge level in the chuOK adventure mode.
 * Contains the question, options, correct answer, and world association.
 */
@Getter
@Setter
@Entity
@Table(name = "levels")
public class Level {

    /** Unique identifier for the level (auto-generated). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Sequential number of the level within its world (required). */
    @NotNull(message = "Level number required")
    private int levelNumber;

    /** The question or challenge content (required). */
    @NotBlank(message = "Content required")
    private String question;

    /** Option 1 for the answer (required). */
    @NotBlank(message = "Option 1 required")
    private String option1;
    /** Option 2 for the answer (required). */
    @NotBlank(message = "Option 2 required")
    private String option2;
    /** Option 3 for the answer (required). */
    @NotBlank(message = "Option 3 required")
    private String option3;
    /** Option 4 for the answer (required). */
    @NotBlank(message = "Option 4 required")
    private String option4;

    /** Index (1-based) of the correct answer option (required). */
    @NotNull(message = "Correct option index required")
    private int correctIndex;

    /** The world to which this level belongs. */
    @ManyToOne
    @JoinColumn(name = "world_id")
    private World world;

    /** List of completed level records for this level (ignored in JSON) to avoid inifinite recursion. */
    @OneToMany(mappedBy = "level")
    @JsonIgnore
    private List<CompletedLevel> completedLevels;

}
