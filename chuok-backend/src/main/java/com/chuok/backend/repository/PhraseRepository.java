package com.chuok.backend.repository;

import com.chuok.backend.model.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for CRUD operations on Phrase entities.
 * Extends JpaRepository to provide standard data access methods.
 */
@Repository
public interface PhraseRepository extends JpaRepository<Phrase, Long> {
}
