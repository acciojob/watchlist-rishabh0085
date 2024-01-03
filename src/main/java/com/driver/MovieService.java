package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    public ResponseEntity<String> addMovie(Movie movie) {
        MovieRepository.addMovie(movie);
        return ResponseEntity.ok("Movie added successfully");
    }

    public ResponseEntity<String> addDirector(Director director) {
        MovieRepository.addDirector(director);
        return ResponseEntity.ok("Director added successfully");
    }

    public ResponseEntity<String> addMovieDirectorPair(String movieName, String directorName) {
        MovieRepository.addMovieDirectorPair(movieName, directorName);
        return ResponseEntity.ok("Movie-Director pair added successfully");
    }

    public ResponseEntity<Movie> getMovieByName(String name) {
        Movie movie = MovieRepository.getMovieByName(name);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Director> getDirectorByName(String name) {
        Director director = MovieRepository.getDirectorByName(name);
        if (director != null) {
            return ResponseEntity.ok(director);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Map<String, Movie>> getMoviesByDirectorName(String directorName) {
        Map<String, Movie> movies = MovieRepository.getMoviesByDirectorName(directorName);
        return ResponseEntity.ok(movies);
    }

    public ResponseEntity<Map<String, Movie>> findAllMovies() {
        Map<String, Movie> movies = MovieRepository.findAllMovies();
        return ResponseEntity.ok(movies);
    }

    public ResponseEntity<String> deleteDirectorByName(String directorName) {
        MovieRepository.deleteDirectorByName(directorName);
        return ResponseEntity.ok("Director and associated movies deleted successfully");
    }

    public ResponseEntity<String> deleteAllDirectors() {
        MovieRepository.deleteAllDirectors();
        return ResponseEntity.ok("All directors and associated movies deleted successfully");
    }
}

