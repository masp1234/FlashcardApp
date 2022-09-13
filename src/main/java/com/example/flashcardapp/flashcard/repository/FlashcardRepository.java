package com.example.flashcardapp.flashcard.repository;

import com.example.flashcardapp.flashcard.model.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
}
