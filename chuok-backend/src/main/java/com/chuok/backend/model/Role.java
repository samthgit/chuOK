package com.chuok.backend.model;

import jakarta.persistence.*;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Role name required")
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users;
}
