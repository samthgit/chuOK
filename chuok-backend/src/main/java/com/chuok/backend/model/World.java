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
@Table(name = "worlds")
public class World {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "World name is required")
    private String name;

    @NotNull(message = "World order is required")
    private int orderIndex;

    @OneToMany(mappedBy = "world")
    @JsonIgnore // ⬅️ Breaks the loop
    private List<Level> levels;
}
