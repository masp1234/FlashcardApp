package com.example.flashcardapp;

import com.example.flashcardapp.deck.model.Deck;
import com.example.flashcardapp.deck.repository.DeckRepository;
import com.example.flashcardapp.flashcard.model.Flashcard;
import com.example.flashcardapp.flashcard.model.TestItem;
import com.example.flashcardapp.flashcard.repository.FlashcardRepository;
import com.example.flashcardapp.testitem.repository.TestItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FlashcardAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlashcardAppApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CommandLineRunner importData(

            FlashcardRepository flashcardRepository,
            DeckRepository deckRepository,
            TestItemRepository testItemRepository
    )
    {
                return (args) -> {

                    Deck deck = new Deck();
                    deck.setName("testdeck");
                    deckRepository.save(deck);

                    Flashcard flashcard = new Flashcard();
                    flashcard.setPoints(5);
                    flashcard.setDeck(deck);
                    flashcardRepository.save(flashcard);

                    TestItem testItem = new TestItem();
                    testItem.setText("test");
                    testItem.setFlashcard(flashcard);
                    testItemRepository.save(testItem);

                    flashcard.setTestItems(List.of(testItem));
                    flashcardRepository.save(flashcard);



                    deck.setFlashcards(List.of(flashcard));


                    deckRepository.save(deck);













                };}}
