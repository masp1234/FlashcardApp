package com.example.flashcardapp.deck.controller;

import com.example.flashcardapp.advice.ApiRequestException;
import com.example.flashcardapp.deck.dto.DeckDto;
import com.example.flashcardapp.deck.factory.DeckDtoFactory;
import com.example.flashcardapp.deck.model.Deck;
import com.example.flashcardapp.deck.service.DeckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/deck")
@RestController
public class DeckController {

    private DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeckDto> getDeckById(@PathVariable("id") Long id) {
        Optional<DeckDto> item = Optional.of(deckService.getDeckById(id)
                .orElseThrow(() -> new ApiRequestException("Could not find deck with id: " + id)));
        return ResponseEntity.ok().body(item.get());
    }

    //TODO Virker ikke. Prøv at tilføje method=POST i html-formularen
    @PostMapping(value = "/add")
    public void addDeck(@RequestBody Deck deck) {
        System.out.println(deckService.addDeck(deck));
    }
}

