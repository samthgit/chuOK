package com.chuok.backend.service;

import com.chuok.backend.model.Phrase;
import com.chuok.backend.repository.PhraseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Phrase entities.
 * Provides methods for CRUD operations on phrases.
 */
@Service
public class PhraseService {
    /** Repository for accessing Phrase data. */
    private final PhraseRepository phraseRepository;

    /**
     * Constructor for dependency injection.
     * @param phraseRepository the PhraseRepository instance
     */
    public PhraseService(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    /**
     * Retrieves all phrases from the database.
     * @return list of all phrases
     */
    public List<Phrase> getAllPhrases() {
        return phraseRepository.findAll();
    }

    /**
     * Retrieves a single phrase by its ID.
     * @param id the phrase ID
     * @return the Phrase if found
     * @throws RuntimeException if not found
     */
    public Phrase getPhraseById(Long id) {
        return phraseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phrase not found with id " + id));
    }

    /**
     * Creates a new phrase in the database.
     * @param phrase the Phrase to create
     * @return the saved Phrase
     */
    public Phrase createPhrase(Phrase phrase) {
        return phraseRepository.save(phrase);
    }

    /**
     * Updates an existing phrase by ID.
     * @param id the phrase ID
     * @param updated the updated Phrase data
     * @return the updated Phrase
     */
    public Phrase updatePhrase(Long id, Phrase updated) {
        Phrase existing = getPhraseById(id);
        existing.setTitle(updated.getTitle());
        existing.setContent(updated.getContent());
        existing.setDate(updated.getDate());
        return phraseRepository.save(existing);
    }

    /**
     * Deletes a phrase by its ID.
     * @param id the phrase ID
     */
    public void deletePhrase(Long id) {
        phraseRepository.deleteById(id);
    }
}
