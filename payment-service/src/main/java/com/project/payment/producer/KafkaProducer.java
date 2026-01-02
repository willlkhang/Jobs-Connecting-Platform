package com.project.payment.producer;

import com.project.base.dto.BookingEvent;
import com.project.payment.domain.Payment;

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

    @Value("${spring.kafka.topic.producer.payment.name}")
    private String paymentTopic;

    public void sendPaymentMessage2UpdateBookingStatus(Long key, BookingEvent bookingEvent) {
        kafkaTemplate.send(paymentTopic, key, bookingEvent); //payment ID
    }

}
