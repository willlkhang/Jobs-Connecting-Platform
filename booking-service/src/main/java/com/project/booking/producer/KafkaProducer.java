package com.project.booking.producer;


import com.project.base.dto.BookingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<Long, BookingEvent> kafkaTemplate;

    @Value("${spring.kafka.topic.producer.booking.name}")
    private String bookingTopic;


    public void sendBookingEvent(Long key, BookingEvent bookingEvent) {
        kafkaTemplate.send(bookingTopic, key, bookingEvent); //booking ID
    }
}
