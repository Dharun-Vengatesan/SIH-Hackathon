package com.moviebooking.controller;

import com.moviebooking.entity.Seat;
import com.moviebooking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeatRestController {

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/api/movies/{id}/seats")
    public ResponseEntity<List<Seat>> getSeatsForMovie(@PathVariable Long id) {
        List<Seat> seats = seatRepository.findByMovieId(id);
        return ResponseEntity.ok(seats);
    }
}
