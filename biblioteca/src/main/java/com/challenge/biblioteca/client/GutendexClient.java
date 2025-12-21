package com.challenge.biblioteca.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GutendexClient {

    private static final String BASE_URL = "https://gutendex.com/books";

    private final HttpClient httpClient;

    public GutendexClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String getBooks(String queryParams) throws IOException, InterruptedException {
        String url = BASE_URL;
        if (queryParams != null && !queryParams.isBlank()) {
            url += "?" +queryParams;
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }


}
