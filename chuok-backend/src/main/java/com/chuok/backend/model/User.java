package com.chuok.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a user in the chuOK application.
 * Stores user credentials, role, and completed levels.
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    /** Unique identifier for the user (auto-generated). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Username (required, 3-20 characters). */
    @NotBlank(message = "Username required")
    @Size(min = 3, max = 20, message = "Username must contain between 3 and 20 characters")
    private String name;

    /** Email address (required, unique). */
    @NotBlank(message = "Email required")
    @Size(message = "Email format not valid")
    @Column(unique = true)
    private String email;

    /** Password (required, must meet complexity requirements). */
    @NotBlank(message = "Password required")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{8,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and be at least 8 characters long"
    )
    private String password;

    /** Role assigned to the user (many-to-one relationship). */
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    /** Set of completed levels by the user (ignored in JSON). */
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<CompletedLevel> completedLevels = new HashSet<>();
}
