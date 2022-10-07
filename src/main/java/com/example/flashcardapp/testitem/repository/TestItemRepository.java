package com.example.flashcardapp.testitem.repository;

import com.example.flashcardapp.flashcard.model.TestItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestItemRepository extends JpaRepository<TestItem, Long> {
}
