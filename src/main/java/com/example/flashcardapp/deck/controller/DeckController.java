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
        Optional<Deck> item = deckService.getDeckById(id);
        if (item.isEmpty()) {
            throw new ApiRequestException("Could not find deck with id: " + id);
        }
        return new ResponseEntity<>(DeckDtoFactory.convertFromEntityToDto(item.get()), HttpStatus.OK);
    }

    //TODO Virker ikke. Prøv at tilføje method=POST i html-formularen
    @PostMapping(value = "/add")
    public void addDeck(@RequestBody Deck deck) {
        System.out.println(deckService.addDeck(deck));
    }
}

