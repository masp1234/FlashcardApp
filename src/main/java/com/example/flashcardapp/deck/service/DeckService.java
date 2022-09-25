package com.example.flashcardapp.deck.service;

import com.example.flashcardapp.deck.dto.DeckDto;
import com.example.flashcardapp.deck.factory.DeckDtoFactory;
import com.example.flashcardapp.deck.model.Deck;
import com.example.flashcardapp.deck.repository.DeckRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeckService {

    private DeckRepository deckRepository;

    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public DeckDto getDeckById(Long id) {
        return DeckDtoFactory.convertFromEntityToDto(deckRepository.findById(id).get());

    }
    public DeckDto addDeck(Deck deck) {
       return DeckDtoFactory.convertFromEntityToDto(deckRepository.save(deck));

    }
    public List<DeckDto> getAllDecks() {
        return DeckDtoFactory.fromEntitiesToDtos(deckRepository.findAll());


    }
}
