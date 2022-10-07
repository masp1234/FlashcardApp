package com.example.flashcardapp.flashcard.model;

import com.example.flashcardapp.deck.model.Deck;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@NamedQuery(name = "Flashcard.findFlashCardsByPoints5AndGreater",
        query = "select f from Flashcard f where f.points >= 5")
public class Flashcard {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "points")
    private int points;

    @ManyToOne()
    @JoinColumn(name = "deck_id")
    @JsonBackReference
    private Deck deck;

    public Flashcard(String questionText, String answerText, int points, Deck deck) {
        this.questionText = questionText;
        this.answerText = answerText;
        this.points = points;
        this.deck = deck;
    }
}

