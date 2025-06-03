package com.chuok.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Level number required")
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

    @NotNull(message = "Correct option index required")
    private int correctIndex;

    @ManyToOne
    @JoinColumn(name = "world_id")
    private World world;

    @OneToMany(mappedBy = "level")
    @JsonIgnore
    private List<CompletedLevel> completedLevels;

}
