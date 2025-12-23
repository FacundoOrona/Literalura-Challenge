package com.challenge.biblioteca.model;

import jakarta.persistence.*;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String idioma;
    private Integer cantidadDescargas;

    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public Integer getCantidadDescargas() { return cantidadDescargas; }
    public void setCantidadDescargas(Integer cantidadDescargas) { this.cantidadDescargas = cantidadDescargas; }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    @Override
    public String toString() {
        return "Libro: " + titulo + " | Autor: " + autor +
                " | Idioma: " + idioma + " | Descargas: " + cantidadDescargas;
    }
}
