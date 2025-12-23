package com.challenge.biblioteca.repositorio;

import com.challenge.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {
    List<Libro> findByIdioma(String idioma);
}
