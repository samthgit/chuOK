package com.chuok.backend.model;

import jakarta.persistence.*;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username required")
    @Size(min = 3, max = 20, message = "Username must contain between 3 and 20 characters")
    private String name;

    @NotBlank(message = "Email required")
    @Size(message = "Email format not valid")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password required")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{8,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and be at least 8 characters long"
    )
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<CompletedLevel> completedLevels;
}
