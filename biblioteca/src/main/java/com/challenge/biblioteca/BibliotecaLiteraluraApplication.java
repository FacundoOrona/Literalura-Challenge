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
    public void run(String... args) {
        mostrarMenu();
    }

    private void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== Biblioteca ===");
            System.out.println("1) Buscar libro por título");
            System.out.println("2) Listar todos los libros");
            System.out.println("3) Listar libros por idioma");
            System.out.println("4) Listar autores");
            System.out.println("5) Listar autores vivos en determinado año");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            try {
                switch (opcion) {
                    case "1":
                        System.out.print("Ingrese título: ");
                        String titulo = scanner.nextLine();
                        Libro libro = servicio.buscarYGuardarPorTitulo(titulo);
                        System.out.println(libro != null ? libro : "No encontrado.");
                        break;

                    case "2":
                        List<Libro> libros = servicio.listarTodosLibros();
                        if (libros.isEmpty()) {
                            System.out.println("No hay libros guardados.");
                        } else {
                            libros.forEach(System.out::println);
                        }
                        break;

                    case "3":
                        System.out.print("Ingrese idioma (ej: es, en): ");
                        String idioma = scanner.nextLine();
                        List<Libro> librosPorIdioma = servicio.listarPorIdioma(idioma);
                        if (librosPorIdioma.isEmpty()) {
                            System.out.println("No se encontraron libros en el idioma: " + idioma);
                        } else {
                            librosPorIdioma.forEach(System.out::println);
                        }
                        break;

                    case "4":
                        List<Autor> autores = servicio.listarAutores();
                        if (autores.isEmpty()) {
                            System.out.println("No hay autores guardados.");
                        } else {
                            autores.forEach(System.out::println);
                        }
                        break;

                    case "5":
                        System.out.print("Ingrese año: ");
                        int anio = Integer.parseInt(scanner.nextLine());
                        List<Autor> autoresVivos = servicio.listarAutoresVivosEnAnio(anio);
                        if (autoresVivos.isEmpty()) {
                            System.out.println("No se encontraron autores vivos en el año " + anio);
                        } else {
                            autoresVivos.forEach(System.out::println);
                        }
                        break;

                    case "0":
                        salir = true;
                        System.out.println("Saliendo... ¡Gracias por usar la biblioteca!");
                        break;

                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
