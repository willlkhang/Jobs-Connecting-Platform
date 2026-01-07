package com.project.booking.service;

import com.project.base.domain.User;
import com.project.base.exception.BusinessException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service")
public interface UserService {

    @GetMapping("/user/{id}")
    ResponseEntity<User> getUserById(@PathVariable Long id);

    @GetMapping("/user")
    ResponseEntity<User> getUserByUserName(@RequestParam("name") String username);

}
