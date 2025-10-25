package com.moviebooking.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "seats")
public class Seat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    
    @Column(name = "seat_number")
    private String seatNumber; // e.g., "A1", "B2", etc.

    @Column(name = "seat_type")
    private String seatType; // e.g., "STANDARD", "VIP", "COUPLE"

    @Column(name = "is_booked")
    private boolean isBooked;

    @Column(name = "price")
    private BigDecimal price;

    // avoid using SQL reserved-like names: use row_no and col_no
    @Column(name = "row_no")
    private int rowNumber; // For display purposes (1 = row A, 2 = row B, etc.)

    @Column(name = "col_no")
    private int columnNumber; // Actual column number for display

    public Seat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }
}