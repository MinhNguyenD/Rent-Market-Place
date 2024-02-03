package com.mlproject.quickLease.mapper;

import com.mlproject.quickLease.dto.BookingDto;
import com.mlproject.quickLease.entity.Booking;
import com.mlproject.quickLease.entity.Room;
import com.mlproject.quickLease.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    @Mapping(target = "room", source = "room")
    Booking mapToEntity(BookingDto bookingDto, UserEntity user, Room room);

    @Mapping(target = "userId", expression = "java(booking.getUser().getUserId())")
    @Mapping(target = "roomId", expression = "java(booking.getRoom().getId())")
    BookingDto mapToDto(Booking booking);
}
