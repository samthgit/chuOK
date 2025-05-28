package com.chuok.backend.model;

import jakarta.persistence.*;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "worlds")
public class World {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "World name is required")
    private String name;

    @NotBlank(message = "World order is required")
    private int orderIndex;

    @OneToMany(mappedBy = "world")
    private Set<Level> levels;
}
