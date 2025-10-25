package com.moviebooking.repository;

import com.moviebooking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByMovieId(Long movieId);
    List<Seat> findByMovieIdAndIsBookedFalse(Long movieId);
}