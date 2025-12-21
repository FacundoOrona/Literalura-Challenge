package com.challenge.biblioteca;

import com.challenge.biblioteca.service.LibroServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaLiteraluraApplication implements CommandLineRunner {

    private final LibroServicio libroServicio;

    public BibliotecaLiteraluraApplication(LibroServicio libroServicio) {
        this.libroServicio = libroServicio;
    }

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaLiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //mostrarMenu();
    }
}
