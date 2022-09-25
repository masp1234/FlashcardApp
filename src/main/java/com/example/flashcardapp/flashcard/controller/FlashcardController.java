package com.example.flashcardapp.flashcard.controller;

import com.example.flashcardapp.advice.ApiRequestException;
import com.example.flashcardapp.flashcard.dto.FlashcardDto;
import com.example.flashcardapp.flashcard.factory.FlashcardDtoFactory;
import com.example.flashcardapp.flashcard.model.Flashcard;
import com.example.flashcardapp.flashcard.service.FlashcardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/flashcard")
@RestController
public class FlashcardController {

    private FlashcardService flashcardService;

    public FlashcardController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<FlashcardDto>> getAllFlashcards() {
        List<Flashcard> flashcards = flashcardService.getAll();
        if (flashcards.isEmpty()) {
            throw new ApiRequestException("No flashcards found");
        }
        return new ResponseEntity<>(FlashcardDtoFactory.fromEntitiesToDtos(flashcards), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Flashcard> getFlashcardById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(flashcardService.getById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/points/greater-or-equals/{value}")
    public ResponseEntity<List<Flashcard>> getFlashcardsGreaterOrEqualTo(@PathVariable("value") int points) {
        return new ResponseEntity<>(flashcardService.getFlashcardsGreaterOrEqualTo(points), HttpStatus.OK);
    }
    @GetMapping("/points/less-or-equals/{value}")
    public ResponseEntity<List<Flashcard>> getFlashcardsLowerOrEqualsTo(@PathVariable("value") int points) {
        return new ResponseEntity<>(flashcardService.getFlashcardsLessThanOrEqualsTo(points), HttpStatus.OK);
    }



}
