package com.project.job.consumer;

import com.project.base.dto.BookingEvent;

import com.project.job.service.SolutionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private SolutionService solutionService;

    @KafkaListener(topics = {"${spring.kafka.topic.consumer.booking.name}"}, groupId = "solution", autoStartup = "true")
    public void updateSolution(BookingEvent bookingEvent) {
        solutionService.increaseProcessedNumber(bookingEvent.getBooking().getBookingId());
    }
}
