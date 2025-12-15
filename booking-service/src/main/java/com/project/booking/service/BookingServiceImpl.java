package com.project.booking.service;

import com.project.base.dto.SolutionDTO;

import com.project.booking.domain.Booking;
import com.project.booking.domain.BookingSolution;

import com.project.booking.repository.BookingSolutionRepository;
import com.project.booking.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingSolutionRepository bookingSolutionRepository;
    @Autowired
    private BookingRepository bookingRepository;



    @Override
    public void updateBooking(Long bookingId) {

    }

    @Override
    public void createBooking(SolutionDTO solutionDTO) {

    }

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        return List.of();
    }
}
