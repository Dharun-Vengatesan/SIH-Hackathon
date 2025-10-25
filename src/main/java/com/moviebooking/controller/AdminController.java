package com.moviebooking.controller;

import com.moviebooking.entity.Movie;
import com.moviebooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private MovieRepository movieRepository;

    // Debug endpoint to view movie data
    @GetMapping("/movies/debug")
    public ResponseEntity<?> getMovieDebugInfo() {
        return ResponseEntity.ok(movieRepository.findAll());
    }

    // Update a movie's poster URL
    @PutMapping("/movies/{id}/poster")
    public ResponseEntity<?> updateMoviePoster(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {
        
        String newPosterUrl = body.get("posterUrl");
        if (newPosterUrl == null || newPosterUrl.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("posterUrl is required");
        }

        return movieRepository.findById(id)
            .map(movie -> {
                movie.setPosterUrl(newPosterUrl);
                movieRepository.save(movie);
                return ResponseEntity.ok(movie);
            })
            .orElse(ResponseEntity.notFound().build());
    }
}