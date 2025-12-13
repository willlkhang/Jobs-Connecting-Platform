package com.project.job.controller;

//base service group
import com.project.base.dto.SolutionDTO;
import com.project.base.dto.Result;
import com.project.base.exception.BusinessException;

//job service group
import com.project.job.service.SolutionService;
import com.project.job.mapper.SolutionMapper;
import com.project.job.domain.Solution;
import com.project.job.repository.SolutionRepository;

//rest api spring boot group
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SolutionController {

    @Autowired
    private SolutionService solutionService;
    @Autowired
    private SolutionMapper solutionMapper;
    @Autowired
    private SolutionRepository solutionRepository;

    @PostMapping("add-solution")
    public ResponseEntity<Solution> addSolution(@RequestBody Solution solution) { //or this can be implied by saving solution
        solutionService.save(solution);
        return ResponseEntity.ok().body(solution);
    }

    @GetMapping("/check-exit-solution")
    public ResponseEntity<SolutionDTO> checkSolutionExist(@RequestParam("solutionName") String name) throws BusinessException {
        SolutionDTO solutionDTO = solutionService.getSolutionByName(name);

        return ResponseEntity.ok(solutionDTO);
    }
}
