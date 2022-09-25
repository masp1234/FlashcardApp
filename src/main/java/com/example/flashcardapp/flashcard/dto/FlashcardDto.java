package com.example.flashcardapp.flashcard.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlashcardDto {

    private Long id;

    private String questionText;

    private String answerText;

    private int points;



}
