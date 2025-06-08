package com.chuok.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a world in the chuOK adventure mode.
 * Each world contains a set of levels and has an order index for progression.
 */
@Getter
@Setter
@Entity
@Table(name = "worlds")
public class World {

    /** Unique identifier for the world (auto-generated). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Name of the world (required). */
    @NotBlank(message = "World name is required")
    private String name;

    /** Order index for the world (required, determines progression). */
    @NotNull(message = "World order is required")
    private int orderIndex;

    /** List of levels belonging to this world (ignored in JSON to prevent recursion). */
    @OneToMany(mappedBy = "world")
    @JsonIgnore // ⬅️ Breaks the loop
    private List<Level> levels;
}
