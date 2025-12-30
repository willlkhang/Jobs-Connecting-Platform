package com.project.booking.service;

import com.project.base.dto.SolutionDTO;
import com.project.base.exception.BusinessException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "job-service")
public interface JobService {

    @GetMapping("/check-exit-solution-by-id")
    ResponseEntity<SolutionDTO> checkSolutionExistById(@RequestParam("solutionId") Long id) throws BusinessException;

    @GetMapping("/check-exit-solution-by-name")
    ResponseEntity<SolutionDTO> checkSolutionExistByName(@RequestParam("solutionName") String name) throws BusinessException;
}
