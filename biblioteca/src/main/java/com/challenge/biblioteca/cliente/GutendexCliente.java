package com.challenge.biblioteca.cliente;

import com.challenge.biblioteca.model.RespuestaGutendex;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GutendexCliente {

    private static final String URL_BASE = "https://gutendex.com/books";
    private final HttpClient clienteHttp;

    public GutendexCliente() {
        this.clienteHttp = HttpClient.newHttpClient();
    }

    public String obtenerLibros(String parametrosConsulta) throws IOException, InterruptedException {

        String url = URL_BASE;
        if (parametrosConsulta != null && !parametrosConsulta.isBlank()) {
            url += "?" + parametrosConsulta;
        }

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> respuesta = clienteHttp.send(solicitud, HttpResponse.BodyHandlers.ofString());

        return respuesta.body();
    }

    public RespuestaGutendex obtenerLibrosComoObjetos(String parametrosConsulta) throws IOException, InterruptedException {
        String json = obtenerLibros(parametrosConsulta);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, RespuestaGutendex.class);
    }
}
