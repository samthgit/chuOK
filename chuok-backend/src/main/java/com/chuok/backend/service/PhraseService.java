package com.chuok.backend.service;

import com.chuok.backend.model.Phrase;
import com.chuok.backend.repository.PhraseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhraseService {
    private final PhraseRepository phraseRepository;

    public PhraseService(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    public List<Phrase> getAllPhrases() {
        return phraseRepository.findAll();
    }

    public Phrase getPhraseById(Long id) {
        return phraseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phrase not found with id " + id));
    }

    public Phrase createPhrase(Phrase phrase) {
        return phraseRepository.save(phrase);
    }

    public Phrase updatePhrase(Long id, Phrase updated) {
        Phrase existing = getPhraseById(id);
        existing.setTitle(updated.getTitle());
        existing.setContent(updated.getContent());
        existing.setDate(updated.getDate());
        return phraseRepository.save(existing);
    }

    public void deletePhrase(Long id) {
        phraseRepository.deleteById(id);
    }
}
