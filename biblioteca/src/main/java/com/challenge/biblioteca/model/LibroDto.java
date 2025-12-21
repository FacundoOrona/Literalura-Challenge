package com.challenge.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LibroDto {

    private int id;
    @JsonAlias("title")
    private String titulo;
    @JsonAlias("authors")
    private List<AutorDto> autores;
    @JsonAlias("languages")
    private List<String> idiomas;
    @JsonAlias("download_count")
    private int cantidadDescargas;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public List<AutorDto> getAutores() { return autores; }
    public void setAutores(List<AutorDto> autores) { this.autores = autores; }

    public List<String> getIdiomas() { return idiomas; }
    public void setIdiomas(List<String> idiomas) { this.idiomas = idiomas; }

    public int getCantidadDescargas() { return cantidadDescargas; }
    public void setCantidadDescargas(int cantidadDescargas) { this.cantidadDescargas = cantidadDescargas; }

    @Override
    public String toString() {
        return "Libro: " +
                "id: " + id +
                ", titulo: '" + titulo + '\'' +
                ", autores: " + autores +
                ", idiomas: " + idiomas +
                ", cantidadDescargas: " + cantidadDescargas;
    }
}


