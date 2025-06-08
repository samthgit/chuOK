package com.chuok.backend.controller;

import com.chuok.backend.model.Phrase;
import com.chuok.backend.service.PhraseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Phrase entities.
 * Provides endpoints for CRUD operations on Phrase resources.
 */
@RestController
@RequestMapping("/api/phrases")
@CrossOrigin(origins = "*")
public class PhraseController {
    /** Service for handling Phrase business logic. */
    private final PhraseService phraseService;

    /**
     * Constructs a PhraseController with the given PhraseService.
     * @param phraseService the service to handle Phrase operations
     */
    public PhraseController(PhraseService phraseService) {
        this.phraseService = phraseService;
    }

    /**
     * Retrieves a list of all phrases.
     * @return list of Phrase entities
     */
    @GetMapping
    public List<Phrase> getAllPhrases() {
        return phraseService.getAllPhrases();
    }

    /**
     * Retrieves a phrase by its ID.
     * @param id the ID of the phrase
     * @return the Phrase entity with the given ID
     */
    @GetMapping("/{id}")
    public Phrase getPhraseById(@PathVariable Long id) {
        return phraseService.getPhraseById(id);
    }

    /**
     * Creates a new phrase.
     * @param phrase the Phrase entity to create
     * @return the created Phrase entity
     */
    @PostMapping
    public Phrase createPhrase(@Valid @RequestBody Phrase phrase) {
        return phraseService.createPhrase(phrase);
    }

    /**
     * Updates an existing phrase by ID.
     * @param id the ID of the phrase to update
     * @param updated the updated Phrase entity
     * @return the updated Phrase entity
     */
    @PutMapping("/{id}")
    public Phrase updatePhrase(@PathVariable Long id, @Valid @RequestBody Phrase updated) {
        return phraseService.updatePhrase(id, updated);
    }

    /**
     * Deletes a phrase by its ID.
     * @param id the ID of the phrase to delete
     */
    @DeleteMapping("/{id}")
    public void deletePhrase(@PathVariable Long id) {
        phraseService.deletePhrase(id);
    }
}
