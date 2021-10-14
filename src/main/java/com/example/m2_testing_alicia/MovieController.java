package com.example.m2_testing_alicia;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    MovieRepository repository;

    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }



    /*GET*/
    @GetMapping("/movies")
    public List<Movie> findAll(){
        return repository.findAll();
    }


    @GetMapping("/datos")
    public void datosDemo(){
        Movie pelicula = new Movie(
                null,
                "Nemo",
                120D);
        repository.save(pelicula);
    }

    /*POST*/

    @PostMapping("/cartelera")
    public void create(@RequestBody Movie movie){
        if (movie.getId() == null)
            repository.save(movie);
    }


    @PutMapping("/cartelera")
    public void update(@RequestBody Movie movie){
        if(movie.getId() != null && repository.existsById(movie.getId()))
            repository.save(movie);
    }

    @DeleteMapping("/cartelera/{id}")
    public void deleteById(@PathVariable Long id){
        if (repository.existsById(id))
            repository.deleteById(id);
    }



}
