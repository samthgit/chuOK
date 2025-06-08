package com.chuok.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing an article in the chuOK application.
 * Used for displaying longer-form content to users.
 */
@Getter
@Setter
@Entity
@Table(name = "articles")
public class Article {

    /** Unique identifier for the article (auto-generated). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Title of the article (required, max 255 characters). */
    @NotBlank(message = "Title required")
    @Size(max = 255, message = "Title cannot have more than 255 characters")
    private String title;

    /** Main content of the article (required, stored as large object). */
    @NotBlank(message = "Content required")
    @Lob
    private String content;

    /** Author of the article (required). */
    @NotBlank(message = "Author required")
    private String author;

    /** Date the article was created or published (required). */
    @NotNull(message = "Date required")
    private LocalDate date;
}
