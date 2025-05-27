package com.chuok.backend.controller;

import com.chuok.backend.model.Phrase;
import com.chuok.backend.service.PhraseService;
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

    @GetMapping
    public List<Phrase> getAllPhrases() {
        return phraseService.getAllPhrases();
    }
}
