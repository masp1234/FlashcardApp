package com.example.flashcardapp.deck.model;

import com.example.flashcardapp.flashcard.model.Flashcard;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString

// En tom constructor er nødvendig for at bruge JPA
@NoArgsConstructor

public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    //TODO Er nået til at skulle lave et relationship mellem Deck og Flashcard
    @OneToMany(mappedBy = "deck")
    @JsonManagedReference
    @ToString.Exclude
    private List<Flashcard> flashcards;

    public Deck(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Deck(Long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
    @Override
    public boolean equals(Object o) {
        Deck otherDeck = (Deck) o;
        return otherDeck.category.equals(this.category) &&
                otherDeck.name.equals(this.name) &&
                otherDeck.id.equals(this.id);
    }
}
