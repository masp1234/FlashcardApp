package com.example.flashcardapp.deck.service;

import com.example.flashcardapp.deck.model.Deck;
import com.example.flashcardapp.deck.repository.DeckRepository;
import com.example.flashcardapp.deck.repository.IDeckRepository;
import org.springframework.stereotype.Service;

@Service
public class DeckService {

    private IDeckRepository deckRepository;

    public DeckService(IDeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public Deck getDeckById(Long id) {
        return deckRepository.getDeckById(id);
    }
}
