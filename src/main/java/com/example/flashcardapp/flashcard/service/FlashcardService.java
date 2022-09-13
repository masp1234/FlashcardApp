package com.example.flashcardapp.flashcard.service;

import com.example.flashcardapp.flashcard.model.Flashcard;
import com.example.flashcardapp.flashcard.repository.FlashcardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlashcardService {

    private FlashcardRepository flashcardRepository;

    public FlashcardService(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    public List<Flashcard> getAll() {
        return flashcardRepository.findAll();
    }
}
