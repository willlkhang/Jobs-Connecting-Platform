/**
 * @Author: Will Nguyen (Minh Khang)
 * @Date: 28/01/2026
 * @Description: This class is for dealing with conflict between authentication in user-service and being called
 * by job-service
 * */
package com.project.job.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {

            //get the current incoming request
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

            if (attributes != null) {
                //extract authorization header (bearer token)
                String authHeader = attributes.getRequest().getHeader("Authorization");

                //if token exists, attach it to feign request
                if (authHeader != null) {
                    requestTemplate.header("Authorization", authHeader);
                }
            }
        };
    }
}
