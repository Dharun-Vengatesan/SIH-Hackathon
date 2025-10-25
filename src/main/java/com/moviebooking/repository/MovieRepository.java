package com.moviebooking.repository;

import com.moviebooking.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    // Find movies by title containing the search term (case-insensitive)
    List<Movie> findByTitleContainingIgnoreCase(String title);
    
    // Find movies by genre
    List<Movie> findByGenre(String genre);
    
    // Find movies by language
    List<Movie> findByLanguage(String language);
    
    // Find active movies
    List<Movie> findByIsActiveTrue();
    
    // Find movies by genre and active status
    List<Movie> findByGenreAndIsActiveTrue(String genre);
    
    // Find movies by language and active status
    List<Movie> findByLanguageAndIsActiveTrue(String language);
}