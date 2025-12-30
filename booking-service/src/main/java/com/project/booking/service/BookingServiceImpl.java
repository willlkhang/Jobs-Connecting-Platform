package com.project.booking.service;

import com.project.base.domain.User;
import com.project.base.dto.BookingDTO;
import com.project.base.dto.SolutionDTO;
import com.project.base.dto.BookingEvent;

import com.project.booking.domain.Booking;
import com.project.booking.domain.BookingSolution;

import com.project.booking.repository.BookingSolutionRepository;
import com.project.booking.repository.BookingRepository;

import com.project.booking.producer.KafkaProducer;

import com.project.booking.util.AppUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingSolutionRepository bookingSolutionRepository;
    @Autowired
    private BookingRepository bookingRepository;

    //feign group
    @Autowired
    private JobService jobService;
    @Autowired
    private UserService userService;

    //Kafka group
    @Autowired
    private KafkaProducer kafkaProducer;

    //util group
    @Autowired
    private AppUtil appUtil;

    @Override
    public void updateBooking(Long bookingId) {
        bookingRepository.updateBookingStatus(bookingId);
    }

    @Override
    public void createBooking(SolutionDTO solutionDTO) {
        Booking booking = new Booking();
        booking.setBookingDate(new Date());
        booking.setStatus(1);

        BigDecimal price = solutionDTO.getPrice();
        booking.setTotalAmount(price);

        String username = appUtil.getUserNameLogin();
        ResponseEntity<User> responseEntity = userService.getUserByUserName(username);

        booking.setUserId(responseEntity.getBody().getId().longValue());

        bookingRepository.save(booking);

        BookingSolution bookingSolution = new BookingSolution();
        bookingSolution.setBookingSolutionId(solutionDTO.getSolutionId());
        bookingSolution.setBooking(booking);

        bookingSolutionRepository.save(bookingSolution);

        //update solution quantity
        //save to payment service
    }

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findBookingByUserId(userId);
    }

}
