package com.example.flashcardapp.flashcard.service;

import com.example.flashcardapp.deck.factory.DeckDtoFactory;
import com.example.flashcardapp.deck.service.DeckService;
import com.example.flashcardapp.flashcard.dto.FlashcardDto;
import com.example.flashcardapp.flashcard.model.Flashcard;
import com.example.flashcardapp.flashcard.repository.FlashcardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlashcardService {

    private FlashcardRepository flashcardRepository;

    public FlashcardService(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    public List<Flashcard> getAll() {
        return flashcardRepository.findAll();
    }

    public Optional<Flashcard> getById(Long id) {
        return flashcardRepository.findById(id);
    }
    public List<Flashcard> getFlashcardsGreaterOrEqualTo(int points) {
        return flashcardRepository.getFlashcardsByPointsGreaterThanEqual(points);
    }

    public List<Flashcard> getFlashcardsLessThanOrEqualsTo(int points) {
        return flashcardRepository.getFlashcardsByPointsLessThanEqual(points);
    }



}
