package com.moviebooking.controller;

import com.moviebooking.entity.Movie;
import com.moviebooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    // GET /api/movies - Get all movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // GET /api/movies/1 - Get a specific movie by ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return movieRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/movies - Create a new movie
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // PUT /api/movies/1 - Update a movie
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
        return movieRepository.findById(id)
                .map(existingMovie -> {
                    existingMovie.setTitle(movieDetails.getTitle());
                    existingMovie.setDescription(movieDetails.getDescription());
                    existingMovie.setGenre(movieDetails.getGenre());
                    existingMovie.setLanguage(movieDetails.getLanguage());
                    existingMovie.setDuration(movieDetails.getDuration());
                    existingMovie.setRating(movieDetails.getRating());
                    existingMovie.setReleaseDate(movieDetails.getReleaseDate());
                    existingMovie.setActive(movieDetails.isActive());
                    existingMovie.setPosterUrl(movieDetails.getPosterUrl());
                    existingMovie.setTicketPrice(movieDetails.getTicketPrice());
                    return ResponseEntity.ok(movieRepository.save(existingMovie));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/movies/1 - Delete a movie
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        return movieRepository.findById(id)
                .map(movie -> {
                    movieRepository.delete(movie);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/movies/search?title=avatar - Search movies by title
    @GetMapping("/search")
    public List<Movie> searchMovies(@RequestParam String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    // GET /api/movies/genre/action - Get movies by genre
    @GetMapping("/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return movieRepository.findByGenreAndIsActiveTrue(genre);
    }

    // GET /api/movies/language/english - Get movies by language
    @GetMapping("/language/{language}")
    public List<Movie> getMoviesByLanguage(@PathVariable String language) {
        return movieRepository.findByLanguageAndIsActiveTrue(language);
    }
}