package com.project.payment.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.topic.producer.payment.name}")
    private String topicPayment;
    @Value("${spring.kafka.topic.consumer.payment.name}")
    private String topicPaymentResult;

    @Bean
    public NewTopic bookingTopic() {
        return TopicBuilder.name(topicPayment)
                .partitions(3)
                .compact()
                .build();
    }

    @Bean
    public NewTopic bookingResult() {
        return TopicBuilder.name(topicPaymentResult)
                .partitions(3)
                .compact()
                .build();
    }
}
