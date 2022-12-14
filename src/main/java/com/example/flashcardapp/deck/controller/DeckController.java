package com.example.flashcardapp.deck.controller;

import com.example.flashcardapp.advice.ResourceNotFoundException;
import com.example.flashcardapp.deck.dto.DeckDto;
import com.example.flashcardapp.deck.factory.DeckDtoFactory;
import com.example.flashcardapp.deck.model.Deck;
import com.example.flashcardapp.deck.service.DeckService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/deck")
@RestController
@CrossOrigin
public class DeckController {

    @Autowired
    private ModelMapper modelMapper;
    private DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeckDto> getDeckById(@PathVariable("id") Long id) {
        Optional<Deck> item = deckService.getDeckById(id);
        if (item.isEmpty()) {
            throw new ResourceNotFoundException("Could not find deck with id: " + id);
        }
        return new ResponseEntity<>(DeckDtoFactory.convertFromEntityToDto(item.get()), HttpStatus.OK);
    }

    //TODO Lav DTO's til alt og begge veje: fra entity til dto og omvendt


    @PostMapping(value = "/add")
    public ResponseEntity<DeckDto> addDeck(@RequestBody Deck deck) {
        deckService.addDeck(deck);
        return new ResponseEntity<>(DeckDtoFactory.convertFromEntityToDto(deck), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Deck>> getAllDecks(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {

        List<Deck> decks = deckService.getAllDecks(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(decks, HttpStatus.OK);
    }
}

