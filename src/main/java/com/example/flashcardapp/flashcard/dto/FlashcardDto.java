package com.example.flashcardapp.flashcard.dto;

import com.example.flashcardapp.deck.dto.DeckDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlashcardDto {

    private Long id;

    private String questionText;

    private String answerText;

    private int points;

    @JsonBackReference
    private DeckDto deck;


}
