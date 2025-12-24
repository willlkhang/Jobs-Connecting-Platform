package com.project.booking.config;

import org.apache.kafka.clients.admin.NewTopic;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.topic.producer.booking.name}")
    private String topicBooking;
    @Value("${spring.kafka.topic.consumer.booking.name}")
    private String topicBookingResult;

    @Bean
    public NewTopic bookingTopic() {
        return TopicBuilder.name(topicBooking)
                .partitions(3)
                .compact()
                .build();
    }

    @Bean
    public NewTopic bookingResult() {
        return TopicBuilder.name(topicBookingResult)
                .partitions(3)
                .compact()
                .build();
    }
}
