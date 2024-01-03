package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService = new MovieService();

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        return movieService.addDirector(director);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(
            @RequestParam String movieName,
            @RequestParam String directorName) {
        return movieService.addMovieDirectorPair(movieName, directorName);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {
        return movieService.getMovieByName(name);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name) {
        return movieService.getDirectorByName(name);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<Map<String, Movie>> getMoviesByDirectorName(@PathVariable String director) {
        return movieService.getMoviesByDirectorName(director);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<Map<String, Movie>> findAllMovies() {
        return movieService.findAllMovies();
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName) {
        return movieService.deleteDirectorByName(directorName);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        return movieService.deleteAllDirectors();
    }
}

