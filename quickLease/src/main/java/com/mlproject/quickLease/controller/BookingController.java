package com.mlproject.quickLease.controller;

import com.mlproject.quickLease.dto.BookingDto;
import com.mlproject.quickLease.entity.Booking;
import com.mlproject.quickLease.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("api/bookings")
public class BookingController {
    public final BookingService bookingService;
    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBooking(@PathVariable int id){
        return new ResponseEntity<>(bookingService.getBooking(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createBooking(@RequestBody BookingDto bookingDto){
        bookingService.saveBooking(bookingDto);
        String message = "Created booking with ID " + bookingDto.getId();
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateBooking(@RequestBody BookingDto bookingDto){
        bookingService.saveBooking(bookingDto);
        String message = "Updated booking with ID " + bookingDto.getId();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id){
        bookingService.deleteBooking(id);
        String message = "Deleted booking with ID " + id;
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

}
