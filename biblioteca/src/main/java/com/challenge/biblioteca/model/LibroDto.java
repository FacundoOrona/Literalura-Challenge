package com.challenge.biblioteca.model;

import java.util.List;

public class LibroDto {
    private int id;
    private String titulo;
    private List<AutorDto> autores;
    private List<String> idiomas;
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
}


