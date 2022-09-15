package com.example.flashcardapp.deck.repository;

import com.example.flashcardapp.deck.model.Deck;

import java.util.List;

public interface IDeckRepository {

    Deck getDeckById(Long id);

    void addDeck(Deck deck);
}
