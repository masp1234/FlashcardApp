package com.example.flashcardapp.flashcard.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
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

    public Flashcard(String questionText, String answerText, int points) {
        this.questionText = questionText;
        this.answerText = answerText;
        this.points = points;
    }
}
