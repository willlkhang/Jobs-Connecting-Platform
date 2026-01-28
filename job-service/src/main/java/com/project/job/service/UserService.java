package com.project.job.service;

import com.project.base.domain.User;
import com.project.job.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", configuration = FeignClientConfig.class)
public interface UserService {

    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable Long id);

    @GetMapping("/")
    ResponseEntity<User> getUserByUserName(@RequestParam("name") String username);

}
