package com.moviebooking.controller;

import com.moviebooking.entity.Movie;
import com.moviebooking.entity.Seat;
import com.moviebooking.repository.MovieRepository;
import com.moviebooking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WebController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("movies", movieRepository.findByIsActiveTrue());
        return "index";
    }

    @GetMapping("/movies/{id}")
    public String movieDetails(@PathVariable Long id, Model model) {
        return movieRepository.findById(id)
                .map(movie -> {
                    model.addAttribute("movie", movie);
                    return "movie-details";
                })
                .orElse("redirect:/");
    }

    @GetMapping("/movies/{id}/seats")
    public String movieSeats(@PathVariable Long id, Model model) {
        return movieRepository.findById(id)
                .map(movie -> {
                    model.addAttribute("movie", movie);
                    List<Seat> seats = seatRepository.findByMovieId(id);
                    List<String> bookedSeats = seats.stream()
                            .filter(Seat::isBooked)
                            .map(Seat::getSeatNumber)
                            .collect(Collectors.toList());
                    model.addAttribute("bookedSeats", bookedSeats);
                    return "movie-seats";
                })
                .orElse("redirect:/");
    }
}