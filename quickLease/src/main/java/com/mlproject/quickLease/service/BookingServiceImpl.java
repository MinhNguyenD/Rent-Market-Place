package com.mlproject.quickLease.service;

import com.mlproject.quickLease.dto.BookingDto;
import com.mlproject.quickLease.entity.Booking;
import com.mlproject.quickLease.entity.Room;
import com.mlproject.quickLease.entity.UserEntity;
import com.mlproject.quickLease.exception.BookingNotFoundException;
import com.mlproject.quickLease.exception.RoomNotFoundException;
import com.mlproject.quickLease.exception.UserNotFoundException;
import com.mlproject.quickLease.mapper.BookingMapper;
import com.mlproject.quickLease.repository.BookingRepository;
import com.mlproject.quickLease.repository.RoomRepository;
import com.mlproject.quickLease.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService{
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final BookingMapper bookingMapper;
    @Override
    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll().stream().map(bookingMapper::mapToDto).toList();
    }

    @Override
    public BookingDto getBooking(int id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException("Booking not found"));
        return bookingMapper.mapToDto(booking);
    }

    @Override
    @Transactional
    public BookingDto createBooking(BookingDto bookingDto) {
        UserEntity user = userRepository.findById(bookingDto.getUserId()).orElseThrow(() -> new UserNotFoundException("User not found in this booking"));
        Room room = roomRepository.findById(bookingDto.getRoomId()).orElseThrow(() -> new RoomNotFoundException("Room not found in this booking"));
        Booking booking = bookingMapper.mapToEntity(bookingDto, user, room);
        bookingRepository.save(booking);
        return bookingDto;
    }

    @Override
    @Transactional
    public BookingDto updateBooking(BookingDto bookingDto) {
        bookingRepository.findById(bookingDto.getId()).orElseThrow(()->new BookingNotFoundException("Booking not found"));
        UserEntity user = userRepository.findById(bookingDto.getUserId()).orElseThrow(() -> new UserNotFoundException("User not found in this booking"));
        Room room = roomRepository.findById(bookingDto.getRoomId()).orElseThrow(() -> new RoomNotFoundException("Room not found in this booking"));
        Booking booking = bookingMapper.mapToEntity(bookingDto, user, room);
        booking.setId(bookingDto.getId());
        bookingRepository.save(booking);
        return bookingDto;
    }


    @Override
    public void deleteBooking(int id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException("Booking not found"));
        bookingRepository.delete(booking);
    }
}
