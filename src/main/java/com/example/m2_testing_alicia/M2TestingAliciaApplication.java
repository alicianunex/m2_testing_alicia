package com.example.m2_testing_alicia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@SpringBootApplication
public class M2TestingAliciaApplication implements CommandLineRunner {

    @Autowired
    MovieRepository movieRepository;

    public static void main(String[] args) {
        SpringApplication.run(M2TestingAliciaApplication.class, args);
    }

    public void showMenu() {
        System.out.println("1 - Crea una película");
        System.out.println("2 - Ver película por id");
        System.out.println("3 - Ver todas las películas");
        System.out.println("4 - Ver película por nombre");
        System.out.println("5 - Borrar todas las películas");
        System.out.println("6 - Salir");
    }

    @Override
    public void run(String... args) {


        while (true) {
            Scanner scanner = new Scanner(System.in);
            showMenu();
            try { // pedir una opción por consola
                int opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion == 1) { // Creando una película
                    System.out.println("Introduce el título de la película");
                    String name = scanner.nextLine();

                    System.out.println("Introduce la duración de la película");
                    Double duracion = scanner.nextDouble();

                    // Crea el objeto
                    Movie movieNueva = new Movie(null, name, duracion);

                    // Guarda el objeto
                    movieRepository.save(movieNueva);
                    System.out.println("Película creada");
                }else if (opcion == 2) {
                    System.out.println("Introduzca el id de la película");
                    Long id = scanner.nextLong();
                    Optional<Movie> movieOptional = movieRepository.findById(id);
                    if (movieOptional.isPresent()) {
                        Movie movie = movieOptional.get();
                        System.out.println(movie);
                    } else { // si no hay película imprimo un texto
                        System.out.println("No existe esa película");
                    }

                }else if (opcion == 3) {
                    // Buscar todas las películas
                    List<Movie> peliculas = movieRepository.findAll();
                    if (peliculas.isEmpty()) {
                        System.out.println("No hay películas disponibles.");
                    } else {
                        System.out.println(peliculas);
                    }

                } else if (opcion == 4) {

                    System.out.println("Introduzca el nombre de la película: ");
                    String name = scanner.nextLine();
                    List<Movie> movies = movieRepository.findByName(name);
                    for (Movie movie : movies)
                        System.out.println(movie);


                } else if (opcion == 5) {

                    System.out.println("Esto borrará todas las películas, escribe true o false para borrar");
                    boolean confirm = scanner.nextBoolean();

                    if (!confirm) continue;

                    movieRepository.deleteAll();
                    System.out.println("Películas borradas correctamente");

                } if (opcion == 6) {
                    System.out.println("¡Hasta pronto!");
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}