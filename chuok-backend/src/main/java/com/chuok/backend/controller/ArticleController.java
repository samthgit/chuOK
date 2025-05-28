package com.chuok.backend.controller;

import com.chuok.backend.model.Article;
import com.chuok.backend.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "*")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // GET - List all articles
    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    // GET - Obtain article by ID
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    // POST - Create new article
    @PostMapping
    public Article createArticle(@Valid @RequestBody Article article) {
        return articleService.createArticle(article);
    }

    // PUT - Update existing article
    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @Valid @RequestBody Article updatedArticle) {
        return articleService.updateArticle(id, updatedArticle);
    }

    // DELETE - Delete article by ID
    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
