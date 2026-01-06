package com.project.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/api/user/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri("lb://user-service"))
                .route("booking-service", r -> r.path("/api/booking/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri("lb://booking-service"))
                .route("job-service", r -> r.path("/api/job/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri("lb://job-service"))
                .route("payment-service", r -> r.path("/api/payment/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri("lb://payment-service"))
                .build();
    }
}