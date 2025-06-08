package com.chuok.backend.repository;

import com.chuok.backend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for CRUD operations on Article entities.
 * Extends JpaRepository to provide standard data access methods.
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
