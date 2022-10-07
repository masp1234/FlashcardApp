package com.example.flashcardapp.deck.repository;

import com.example.flashcardapp.deck.model.Deck;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DeckRepositoryTest {

    @Autowired
    private DeckRepository deckRepository;


    @Test
    void getDeckById() {
        Deck actual = deckRepository.findById(1L).get();

        Deck expected = new Deck(1L, "Deck1", "kategori");

        assertEquals(expected, actual, "Should have the same values");
    }
}
