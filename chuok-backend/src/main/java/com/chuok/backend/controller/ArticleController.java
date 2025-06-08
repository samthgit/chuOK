package com.chuok.backend.controller;

import com.chuok.backend.model.Article;
import com.chuok.backend.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Article entities.
 * Provides endpoints for CRUD operations on articles.
 */
@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "*")
public class ArticleController {
    /** Service for article business logic. */
    private final ArticleService articleService;

    /**
     * Constructor for dependency injection.
     * @param articleService the ArticleService instance
     */
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * GET /api/articles - List all articles.
     * @return list of all Article entities
     */
    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    /**
     * GET /api/articles/{id} - Get an article by ID.
     * @param id the article ID
     * @return the Article entity
     */
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    /**
     * POST /api/articles - Create a new article.
     * @param article the Article to create
     * @return the created Article
     */
    @PostMapping
    public Article createArticle(@Valid @RequestBody Article article) {
        return articleService.createArticle(article);
    }

    /**
     * PUT /api/articles/{id} - Update an existing article.
     * @param id the article ID
     * @param updatedArticle the updated Article data
     * @return the updated Article
     */
    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @Valid @RequestBody Article updatedArticle) {
        return articleService.updateArticle(id, updatedArticle);
    }

    /**
     * DELETE /api/articles/{id} - Delete an article by ID.
     * @param id the article ID
     */
    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
