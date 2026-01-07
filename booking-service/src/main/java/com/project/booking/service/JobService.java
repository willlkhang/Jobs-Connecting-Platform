package com.project.booking.service;

import com.project.base.dto.SolutionDTO;
import com.project.base.exception.BusinessException;

import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "job-service")
public interface JobService {

    @GetMapping("/solution/{id}")
    ResponseEntity<SolutionDTO> checkSolutionExistById(@PathVariable Long id) throws BusinessException;

    @GetMapping("/solution")
    ResponseEntity<SolutionDTO> checkSolutionExistByName(@RequestParam String name) throws BusinessException;
}
