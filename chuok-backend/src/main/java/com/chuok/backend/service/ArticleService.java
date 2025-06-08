package com.chuok.backend.service;

import com.chuok.backend.model.Article;
import com.chuok.backend.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Article entities.
 * Provides methods for CRUD operations on articles.
 */
@Service
public class ArticleService {
    /** Repository for accessing Article data. */
    private final ArticleRepository articleRepository;

    /**
     * Constructor for dependency injection.
     * @param articleRepository the ArticleRepository instance
     */
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    /**
     * Retrieves all articles from the database.
     * @return list of all articles
     */
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    /**
     * Retrieves a single article by its ID.
     * @param id the article ID
     * @return the Article if found
     * @throws RuntimeException if not found
     */
    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found with id " + id));
    }

    /**
     * Creates a new article in the database.
     * @param article the Article to create
     * @return the saved Article
     */
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    /**
     * Updates an existing article by ID.
     * @param id the article ID
     * @param updatedArticle the updated Article data
     * @return the updated Article
     */
    public Article updateArticle(Long id, Article updatedArticle) {
        Article existing = getArticleById(id);
        existing.setTitle(updatedArticle.getTitle());
        existing.setContent(updatedArticle.getContent());
        existing.setAuthor(updatedArticle.getAuthor());
        existing.setDate(updatedArticle.getDate());
        return articleRepository.save(existing);
    }

    /**
     * Deletes an article by its ID.
     * @param id the article ID
     */
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
