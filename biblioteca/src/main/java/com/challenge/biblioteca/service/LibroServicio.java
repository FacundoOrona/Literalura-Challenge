package com.challenge.biblioteca.service;

import com.challenge.biblioteca.cliente.GutendexCliente;
import com.challenge.biblioteca.model.*;
import com.challenge.biblioteca.repositorio.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class LibroServicio {

    private final GutendexCliente cliente;
    private final LibroRepositorio libroRepo;
    private final AutorRepositorio autorRepo;

    public LibroServicio(GutendexCliente cliente, LibroRepositorio libroRepo, AutorRepositorio autorRepo) {
        this.cliente = cliente;
        this.libroRepo = libroRepo;
        this.autorRepo = autorRepo;
    }

    public Libro buscarYGuardarPorTitulo(String titulo) throws IOException, InterruptedException {
        RespuestaGutendex respuesta = cliente.obtenerLibrosComoObjetos("search=" + titulo);
        if (respuesta.getResultados().isEmpty()) return null;

        LibroDto dto = respuesta.getResultados().get(0);

        Autor autor = new Autor();
        if (!dto.getAutores().isEmpty()) {
            AutorDto autorDto = dto.getAutores().get(0);
            autor.setNombre(autorDto.getNombre());
            autor.setAnioNacimiento(autorDto.getAnioNacimiento());
            autor.setAnioFallecimiento(autorDto.getAnioFallecimiento());
        }

        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());
        libro.setIdioma(dto.getIdiomas().isEmpty() ? "desconocido" : dto.getIdiomas().get(0));
        libro.setCantidadDescargas(dto.getCantidadDescargas());
        libro.setAutor(autor);

        autorRepo.save(autor);
        return libroRepo.save(libro);
    }

    public List<Libro> listarTodosLibros() {
        return libroRepo.findAll();
    }

    public List<Libro> listarPorIdioma(String idioma) {
        return libroRepo.findByIdioma(idioma);
    }

    public List<Autor> listarAutores() {
        return autorRepo.findAll();
    }

    public List<Autor> listarAutoresVivosEnAnio(int anio) {
        return autorRepo.findByAnioNacimientoLessThanEqualAndAnioFallecimientoGreaterThanEqual(anio, anio);
    }
}
