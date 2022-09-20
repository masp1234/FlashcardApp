package com.example.flashcardapp.deck.repository;

import com.example.flashcardapp.deck.model.Deck;

import java.util.List;

public interface IDeckRepository {

    Deck getDeckById(Long id);

    Deck addDeck(Deck deck);

    List<Deck> getAllDecksOrderedByCategory();

    void saveAllDecks(List<Deck> decks);
}
