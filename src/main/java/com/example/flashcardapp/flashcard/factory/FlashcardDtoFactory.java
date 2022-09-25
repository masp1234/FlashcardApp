package com.example.flashcardapp.flashcard.factory;

import com.example.flashcardapp.deck.factory.DeckDtoFactory;
import com.example.flashcardapp.flashcard.dto.FlashcardDto;
import com.example.flashcardapp.flashcard.model.Flashcard;

import java.util.List;
import java.util.stream.Collectors;

public class FlashcardDtoFactory {





  public static List<FlashcardDto> fromEntitiesToDtos(List<Flashcard> flashcards) {
      return flashcards.stream()
              .map(f -> convertFromEntityToDto(f))
              .collect(Collectors.toList());
  }


    public static FlashcardDto convertFromEntityToDto(Flashcard flashcard) {
        FlashcardDto flashcardDto = new FlashcardDto();
        flashcardDto.setId(flashcard.getId());
        flashcardDto.setQuestionText(flashcard.getQuestionText());
        flashcardDto.setAnswerText(flashcard.getAnswerText());
        flashcardDto.setPoints(flashcard.getPoints());
        flashcardDto.setDeck(DeckDtoFactory.convertFromEntityToDto(flashcard.getDeck()));
        return flashcardDto;
    }
}
