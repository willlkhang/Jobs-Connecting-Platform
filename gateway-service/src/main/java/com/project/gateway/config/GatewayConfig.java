package com.project.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

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

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();

        corsConfig.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));

        //llow HTTP methods (GET, POST, PUT, DELETE, OPTIONS)
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfig.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}