package com.example.flashcardapp.deck.factory;

import com.example.flashcardapp.deck.dto.DeckDto;
import com.example.flashcardapp.deck.model.Deck;
import com.example.flashcardapp.flashcard.factory.FlashcardDtoFactory;

import java.util.List;
import java.util.stream.Collectors;

public class DeckDtoFactory {


    public static List<DeckDto> fromEntitiesToDtos(List<Deck> decks) {
        return decks.stream()
                .map(d -> convertFromEntityToDto(d))
                .collect(Collectors.toList());

    }

    public static DeckDto convertFromEntityToDto(Deck deck) {
        DeckDto deckDto = new DeckDto();
        deckDto.setId(deck.getId());
        deckDto.setName(deck.getName());
        deckDto.setCategory(deck.getCategory());

        /*
        if (deck.getFlashcards() != null) {
            deckDto.setFlashcards(FlashcardDtoFactory.fromEntitiesToDtos(deck.getFlashcards()));
        }

         */
        return deckDto;
    }
}
