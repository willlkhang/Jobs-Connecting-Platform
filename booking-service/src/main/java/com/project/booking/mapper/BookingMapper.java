package com.project.booking.mapper;

import com.project.base.dto.BookingDTO;
import com.project.booking.domain.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingDTO bookingDTO(Booking booking);
}
