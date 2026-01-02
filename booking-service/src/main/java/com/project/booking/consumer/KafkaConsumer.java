package com.project.booking.consumer;

import com.project.booking.service.BookingService;
import com.project.base.dto.BookingEvent;
import com.project.base.dto.BookingStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private BookingService bookingService;

    @KafkaListener(topics = {"${spring.kafka.topic.consumer.booking.name}"}, groupId = "payment", autoStartup = "true")
    public void updateBookingStatus2SaveDone(BookingEvent bookingEvent) {
        bookingService.updateBookingStatus(bookingEvent.getBooking().getBookingId(), BookingStatus.DONE);
    }
}
