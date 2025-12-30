package com.project.booking.mapper;

import com.project.base.dto.BookingDTO;
import com.project.booking.domain.Booking;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-30T19:00:44+1030",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Amazon.com Inc.)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingDTO bookingDTO(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setBookingId( booking.getBookingId() );
        bookingDTO.setUserId( booking.getUserId() );
        bookingDTO.setTotalAmount( booking.getTotalAmount() );
        bookingDTO.setStatus( booking.getStatus() );
        bookingDTO.setBookingDate( booking.getBookingDate() );

        return bookingDTO;
    }
}
