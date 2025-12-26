package com.project.job.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.topic.producer.job.name}")
    private String topicJob;
    @Value("${spring.kafka.topic.consumer.job.name}")
    private String topicJobResult;

    @Bean
    public NewTopic bookingTopic() {
        return TopicBuilder.name(topicJob)
                .partitions(3)
                .compact()
                .build();
    }

    @Bean
    public NewTopic bookingResult() {
        return TopicBuilder.name(topicJobResult)
                .partitions(3)
                .compact()
                .build();
    }
}
