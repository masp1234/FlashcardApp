package com.example.flashcardapp;

import com.example.flashcardapp.deck.model.Deck;
import com.example.flashcardapp.deck.repository.DeckRepository;
import com.example.flashcardapp.flashcard.model.Flashcard;
import com.example.flashcardapp.flashcard.repository.FlashcardRepository;
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
    public CommandLineRunner importData(

            FlashcardRepository flashcardRepository,
            DeckRepository deckRepository
    )
    {
                return (args) -> {


                    Deck deck = new Deck("Deck1", "kategori");
                    deckRepository.save(deck);

                    List<Deck> decks = new ArrayList<>();
                    decks.add(new Deck("Deck2", "dgfafg"));
                    decks.add(new Deck("Deck3", "sssg"));
                    decks.add(new Deck("Deck4", "agfhg"));

                    deckRepository.saveAll(decks);

                    final List<Flashcard> flashcards = new ArrayList<>();
                    flashcards.add(new Flashcard(
                            "Hvad er scrum?",
                            "En process-model",
                            3, deck
                    ));
                    flashcards.add(new Flashcard(
                            "Hvad er XP?",
                            "En udviklings-model",
                            3, deck
                    ));
                    flashcards.add(new Flashcard(
                            "Hvad menes der med Product Backlog?",
                            "En samling af alle de artefakter, der skal laves" +
                                    "i et scrum-projekt. Udvikler/ændre sig over tid(er levende)",
                            5, deck
                    ));
                    flashcards.add(new Flashcard(
                            "Hvad menes der med Sprint Backlog?",
                            "En samling af artefakter, der er udvalgt til " +
                                    "at skulle laves i et givent sprint" +
                                    ". Artefakterne udvælges fra Product Backlog",
                            5, deck
                    ));



                    flashcardRepository.saveAll(flashcards);

                    System.out.println(deckRepository.getAllDecksOrderedByCategory());









                };}}
