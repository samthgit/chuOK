package com.chuok.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title required")
    @Size(max = 255, message = "Title cannot have more than 255 characters")
    private String title;

    @NotBlank(message = "Content required")
    @Lob
    private String content;

    @NotBlank(message = "Author required")
    private String author;

    @NotBlank(message = "Date required")
    private LocalDate date;
}
