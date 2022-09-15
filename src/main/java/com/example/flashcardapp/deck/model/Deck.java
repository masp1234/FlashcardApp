package com.example.flashcardapp.deck.model;

import com.example.flashcardapp.flashcard.model.Flashcard;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter

// En tom constructor er nødvendig for at bruge JPA
@NoArgsConstructor
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    //TODO Er nået til at skulle lave et relationship mellem Deck og Flashcard
    @OneToMany(mappedBy = "deck")
    @JsonManagedReference
    private List<Flashcard> flashcards;

    public Deck(String name, String category) {
        this.name = name;
        this.category = category;
    }
}
