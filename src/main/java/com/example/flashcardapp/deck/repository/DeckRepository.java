package com.example.flashcardapp.deck.repository;

import com.example.flashcardapp.deck.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DeckRepository extends PagingAndSortingRepository<Deck, Long> {

    @Query("select d from Deck d order by d.category")
    List<Deck> getAllDecksOrderedByCategory();
}

