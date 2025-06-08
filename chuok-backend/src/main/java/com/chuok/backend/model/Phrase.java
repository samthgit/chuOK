package com.chuok.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a short phrase or quote in the chuOK application.
 * Used for displaying inspirational or educational content to users.
 */
@Getter
@Setter
@Entity
@Table(name = "phrases")
public class Phrase {

    /** Unique identifier for the phrase (auto-generated). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Title of the phrase (required, max 255 characters). */
    @NotBlank(message = "Title required")
    @Size(max = 255, message = "Title cannot have more than 255 characters")
    private String title;

    /** Main content of the phrase (required, stored as large object). */
    @NotBlank(message = "Content required")
    @Lob
    private String content;

    /** Date the phrase was created or published (required). */
    @NotNull(message = "Date required")
    private LocalDate date;
}
