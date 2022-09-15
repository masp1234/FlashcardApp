package com.example.flashcardapp.deck.controller;

import com.example.flashcardapp.deck.model.Deck;
import com.example.flashcardapp.deck.service.DeckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/deck")
@RestController
public class DeckController {

    private DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deck> getDeckById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(deckService.getDeckById(id), HttpStatus.OK);
    }
}

