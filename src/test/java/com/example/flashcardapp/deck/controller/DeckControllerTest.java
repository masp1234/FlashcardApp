package com.example.flashcardapp.deck.controller;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DeckControllerTest {
    private final String BASE_URL = "http://localhost:8080/api/deck/";


    @Test
    void deckByIdNotFoundStatusCode() throws IOException {

        Long testId = 20L;

        HttpUriRequest request = new HttpGet(BASE_URL + testId);

        HttpResponse response = HttpClientBuilder.create()
                .build().execute(request);

        int expectedHttpStatusCode = 404;


        assertEquals(expectedHttpStatusCode, response.getStatusLine().getStatusCode());

    }
    @Test void getDeckByIdOkStatusCode() throws IOException {

        Long testId = 1L;

        HttpUriRequest request = new HttpGet(BASE_URL + testId);

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        int expectedHttpStatusCode = 200;

        assertEquals(expectedHttpStatusCode, response.getStatusLine().getStatusCode());

    }


}
