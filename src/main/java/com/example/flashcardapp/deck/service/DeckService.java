package com.example.flashcardapp.deck.service;

import com.example.flashcardapp.deck.dto.DeckDto;
import com.example.flashcardapp.deck.factory.DeckDtoFactory;
import com.example.flashcardapp.deck.model.Deck;
import com.example.flashcardapp.deck.repository.DeckRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.List.of;


@Service
public class DeckService {

    private DeckRepository deckRepository;

    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public Optional<Deck> getDeckById(Long id) {
        return deckRepository.findById(id);

    }
    public DeckDto addDeck(Deck deck) {
       return DeckDtoFactory.convertFromEntityToDto(deckRepository.save(deck));

    }
    public List<Deck> getAllDecks(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Deck> pagedResult = deckRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        }
        else {
            return new ArrayList<Deck>();
        }
    }

}
