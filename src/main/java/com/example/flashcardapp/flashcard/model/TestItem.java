package com.example.flashcardapp.flashcard.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "test_item")
public class TestItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "flashcard_id")
    private Flashcard flashcard;

    @Column(name = "text")
    private String text;

}