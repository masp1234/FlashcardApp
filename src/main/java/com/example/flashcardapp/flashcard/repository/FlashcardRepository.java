package com.example.flashcardapp.flashcard.repository;

import com.example.flashcardapp.flashcard.model.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {


    List<Flashcard> getFlashcardsByPointsGreaterThanEqual(int points);

    List<Flashcard> getFlashcardsByPointsLessThanEqual(int points);




}
