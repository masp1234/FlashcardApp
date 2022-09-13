package com.example.flashcardapp.deck.model;

import com.example.flashcardapp.flashcard.model.Flashcard;

import javax.persistence.*;
import java.util.List;

@Entity
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    //TODO Er nået til at skulle lave et relationship mellem Deck og Flashcard
    @OneToMany()
    private List<Flashcard> flashcards;


}
