package com.project.booking.controller;

import com.project.base.constant.ApplicationConstant;

import com.project.base.dto.SolutionDTO;
import com.project.base.dto.BookingDTO;
import com.project.base.dto.Result;
import com.project.base.exception.BusinessException;

import com.project.booking.domain.Booking;
import com.project.booking.mapper.BookingMapper;
import com.project.booking.repository.BookingRepository;
import com.project.booking.service.BookingService;
import com.project.booking.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collector;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;
    @Autowired
    BookingMapper bookingMapper;
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    JobService jobService;

    @PostMapping("/save-new-booking")
    public ResponseEntity<?> saveNewBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return ResponseEntity.ok().body(booking);
    }

    @PostMapping("create-booking")
    public ResponseEntity<?> createBooking(@RequestParam String solutionName){
        ResponseEntity<SolutionDTO> exist = jobService.checkSolutionExistByName(solutionName);
        SolutionDTO solutionDTO = exist.getBody();

        if(exist.getBody() == null){
            throw new BusinessException("Booking can be created due to unexist solution\n");
        }

        bookingService.createBooking(solutionDTO);
        return ResponseEntity.ok("Booking created successfully");
    }

}
