package com.driver;

import java.util.HashMap;
import java.util.Map;

public class MovieRepository {
    private static final Map<String, Movie> movieMap = new HashMap<>();
    private static final Map<String, Director> directorMap = new HashMap<>();

    public static void addMovie(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public static void addDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public static void addMovieDirectorPair(String movieName, String directorName) {
        Movie movie = movieMap.get(movieName);
        Director director = directorMap.get(directorName);

        // Assuming valid movie and director references
        movie.setImdbRating(director.getImdbRating());
        movie.setDurationInMinutes(director.getNumberOfMovies() * 10); // Just an example logic
    }

    public static Movie getMovieByName(String name) {
        return movieMap.get(name);
    }

    public static Director getDirectorByName(String name) {
        return directorMap.get(name);
    }

    public static Map<String, Movie> getMoviesByDirectorName(String directorName) {
        Map<String, Movie> result = new HashMap<>();
        for (Map.Entry<String, Movie> entry : movieMap.entrySet()) {
            if (entry.getValue().getName().equals(directorName)) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    public static Map<String, Movie> findAllMovies() {
        return new HashMap<>(movieMap);
    }

    public static void deleteDirectorByName(String directorName) {
        directorMap.remove(directorName);
        // Also remove movies associated with the director (assuming unique director names)
        movieMap.entrySet().removeIf(entry -> entry.getValue().getName().equals(directorName));
    }

    public static void deleteAllDirectors() {
        directorMap.clear();
        movieMap.clear();
    }
}
