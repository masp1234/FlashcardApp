package com.example.flashcardapp.deck.service;

import com.example.flashcardapp.deck.dto.DeckDto;
import com.example.flashcardapp.deck.factory.DeckDtoFactory;
import com.example.flashcardapp.deck.model.Deck;
import com.example.flashcardapp.deck.repository.DeckRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.List.of;


@Service
public class DeckService {

    private DeckRepository deckRepository;

    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public Optional<Deck> getDeckById(Long id) {
        return deckRepository.findById(id);

    }
    public DeckDto addDeck(Deck deck) {
       return DeckDtoFactory.convertFromEntityToDto(deckRepository.save(deck));

    }
    public List<DeckDto> getAllDecks() {
        return DeckDtoFactory.fromEntitiesToDtos(deckRepository.findAll());


    }
}
