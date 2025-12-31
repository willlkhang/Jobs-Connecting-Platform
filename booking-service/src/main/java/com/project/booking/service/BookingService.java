package com.project.booking.service;

import com.project.booking.domain.Booking;
import com.project.base.dto.SolutionDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookingService {

    List<Booking> getBookingsByUserId(Long userId);

    void createBooking(SolutionDTO solutionDTO);

    void updateBooking(Long bookingId);

}
