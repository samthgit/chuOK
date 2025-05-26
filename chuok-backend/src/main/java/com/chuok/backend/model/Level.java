package com.chuok.backend.model;

import jakarta.persistence.*;
import java.util.Set;
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

    private int levelNumber;

    private String question;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private int correctIndex;

    @ManyToOne
    @JoinColumn(name = "world_id")
    private World world;

    @OneToMany(mappedBy = "level")
    private Set<CompletedLevel> completedLevels;
}
