package com.chuok.backend.controller;

import com.chuok.backend.model.Phrase;
import com.chuok.backend.service.PhraseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phrases")
@CrossOrigin(origins = "*")
public class PhraseController {
    private final PhraseService phraseService;

    public PhraseController(PhraseService phraseService) {
        this.phraseService = phraseService;
    }

    // GET - List all phrases
    @GetMapping
    public List<Phrase> getAllPhrases() {
        return phraseService.getAllPhrases();
    }

    // GET - Obtain phrase by ID
    @GetMapping("/{id}")
    public Phrase getPhraseById(@PathVariable Long id) {
        return phraseService.getPhraseById(id);
    }

    // POST - Create new phrase
    @PostMapping
    public Phrase createPhrase(@Valid @RequestBody Phrase phrase) {
        return phraseService.createPhrase(phrase);
    }

    // PUT - Update existing phrase
    @PutMapping("/{id}")
    public Phrase updatePhrase(@PathVariable Long id, @Valid @RequestBody Phrase updated) {
        return phraseService.updatePhrase(id, updated);
    }

    // DELETE - Delete phrase by id
    @DeleteMapping("/{id}")
    public void deletePhrase(@PathVariable Long id) {
        phraseService.deletePhrase(id);
    }
}
