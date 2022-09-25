package com.example.flashcardapp.deck.dto;


import com.example.flashcardapp.flashcard.dto.FlashcardDto;
import com.example.flashcardapp.flashcard.model.Flashcard;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DeckDto {

    private Long id;

    private String name;

    private String category;

    @JsonManagedReference
    // TODO Bør være FlashDTO's i stedet ??
    private List<FlashcardDto> flashcards;



}
