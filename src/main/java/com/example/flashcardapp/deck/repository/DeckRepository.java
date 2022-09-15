package com.example.flashcardapp.deck.repository;

import com.example.flashcardapp.deck.model.Deck;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DeckRepository implements IDeckRepository{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public Deck getDeckById(Long id) {
       return entityManager.find(Deck.class, id);
    }

    @Override

    //Nødvendig for at entityManager kan eksekvere(ved ikke hvorfor)
    @Transactional
    public void addDeck(Deck deck) {
        entityManager.persist(deck);
    }
}
