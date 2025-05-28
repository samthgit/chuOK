package com.chuok.backend.model;

import jakarta.persistence.*;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "levels")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Level number required")
    private int levelNumber;

    @NotBlank(message = "Content required")
    private String question;

    @NotBlank(message = "Option 1 required")
    private String option1;
    @NotBlank(message = "Option 2 required")
    private String option2;
    @NotBlank(message = "Option 3 required")
    private String option3;
    @NotBlank(message = "Option 4 required")
    private String option4;

    @NotBlank(message = "Correct option index required")
    private int correctIndex;

    @ManyToOne
    @JoinColumn(name = "world_id")
    private World world;

    @OneToMany(mappedBy = "level")
    private Set<CompletedLevel> completedLevels;
}
