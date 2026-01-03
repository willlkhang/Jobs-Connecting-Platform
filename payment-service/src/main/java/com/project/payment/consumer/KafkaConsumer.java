package com.project.payment.consumer;

import com.project.base.dto.BookingEvent;

import com.project.payment.enumerator.PaymentStatus;
import com.project.payment.service.PaymentService;

import com.project.payment.producer.KafkaProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private KafkaProducer kafkaProducer;

    @KafkaListener(topics = {"${spring.kafka.topic.consumer.booking.name}"}, groupId = "payment", autoStartup = "true")
    public void savePayment2Db(BookingEvent bookingEvent) {
        paymentService.savePayment(bookingEvent.getBooking().getBookingId(), bookingEvent.getBooking().getTotalAmount());

        paymentService.updatePaymentStatus(bookingEvent.getBooking().getBookingId(), PaymentStatus.DONE);

        kafkaProducer.sendPaymentMessage2UpdateBookingStatus(bookingEvent.getBooking().getBookingId(), bookingEvent);
    }
}
