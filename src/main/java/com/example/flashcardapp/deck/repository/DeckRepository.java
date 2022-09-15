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

    @Override
    // TODO hvorfor behøver denne ikke være @transactional?
    public List<Deck> getAllDecksOrderedByCategory() {
        String query = "select d from Deck d order by d.category";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public void saveAllDecks(List<Deck> decks) {
        for (Deck deck: decks) {
            entityManager.persist(deck);
        }
    }
}
