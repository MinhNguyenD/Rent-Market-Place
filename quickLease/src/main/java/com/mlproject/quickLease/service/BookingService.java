package com.mlproject.quickLease.service;

import com.mlproject.quickLease.dto.BookingDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
public interface BookingService {
    public List<BookingDto> getAllBookings();
    public BookingDto getBooking(@PathVariable int id);
    public void saveBooking(@RequestBody BookingDto bookingDto);
    public void deleteBooking(@PathVariable int id);
}
