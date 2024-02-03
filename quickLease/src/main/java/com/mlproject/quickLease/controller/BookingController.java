package com.mlproject.quickLease.controller;

import com.mlproject.quickLease.dto.BookingDto;
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
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto){
        return new ResponseEntity<>(bookingService.createBooking(bookingDto),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BookingDto> updateBooking(@RequestBody BookingDto bookingDto){
        return new ResponseEntity<>(bookingService.updateBooking(bookingDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable int id){
        bookingService.deleteBooking(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
