package com.mlproject.quickLease.service;

import com.mlproject.quickLease.dto.BookingDto;
import com.mlproject.quickLease.dto.RoomDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
public interface BookingService {
    List<BookingDto> getAllBookings();
    BookingDto getBooking(@PathVariable int id);
    BookingDto createBooking(@RequestBody BookingDto bookingDto);
    BookingDto updateBooking(@RequestBody BookingDto bookingDto);

    void deleteBooking(@PathVariable int id);
}
