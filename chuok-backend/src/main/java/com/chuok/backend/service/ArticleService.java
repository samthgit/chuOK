package com.chuok.backend.service;

import com.chuok.backend.model.Article;
import com.chuok.backend.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found with id " + id));
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, Article updatedArticle) {
        Article existing = getArticleById(id);
        existing.setTitle(updatedArticle.getTitle());
        existing.setContent(updatedArticle.getContent());
        existing.setAuthor(updatedArticle.getAuthor());
        existing.setDate(updatedArticle.getDate());
        return articleRepository.save(existing);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
