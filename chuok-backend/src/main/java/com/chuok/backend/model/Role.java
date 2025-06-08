package com.chuok.backend.model;

import jakarta.persistence.*;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a user role (e.g., USER, ADMIN) in the chuOK application.
 * Used for role-based access control and user management.
 */
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

    /** Unique identifier for the role (auto-generated). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Name of the role (required, e.g., 'USER', 'ADMIN'). */
    @NotBlank(message = "Role name required")
    private String name;

    /** Set of users assigned to this role. */
    @OneToMany(mappedBy = "role")
    private Set<User> users;
}
