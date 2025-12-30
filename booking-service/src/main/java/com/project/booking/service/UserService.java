package com.project.booking.service;

import com.project.base.domain.User;
import com.project.base.exception.BusinessException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service")
public interface UserService {

    @GetMapping("/get-user-by-id")
    ResponseEntity<User> getUserById(@RequestParam("userId") Long id);

    @GetMapping("/get-user-by-username")
    ResponseEntity<User> getUserByUserName(@RequestParam("username") String username);

}
