package com.project.booking.controller;

import com.project.base.dto.SolutionDTO;
import com.project.base.exception.BusinessException;

import com.project.booking.domain.Booking;
import com.project.booking.service.BookingService;
import com.project.booking.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    JobService jobService;

    @PostMapping("/save")
    public ResponseEntity<?> saveNewBooking(@RequestBody Booking booking){
        bookingService.saveBooking(booking);
        return ResponseEntity.ok().body(booking);
    }

    @PostMapping("create")
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
