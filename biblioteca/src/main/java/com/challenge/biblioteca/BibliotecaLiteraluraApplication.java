package com.challenge.biblioteca;

import com.challenge.biblioteca.model.Autor;
import com.challenge.biblioteca.model.Libro;
import com.challenge.biblioteca.service.LibroServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BibliotecaLiteraluraApplication implements CommandLineRunner {

    private final LibroServicio servicio;

    public BibliotecaLiteraluraApplication(LibroServicio servicio) {
        this.servicio = servicio;
    }

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaLiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //mostrarMenu();
    }
}
