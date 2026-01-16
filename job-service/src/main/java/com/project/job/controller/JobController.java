package com.project.job.controller;

//base service group
import com.project.base.dto.SolutionDTO;
import com.project.base.dto.Result;
import com.project.base.exception.BusinessException;

//job service group
import com.project.job.service.SolutionService;
import com.project.job.domain.Solution;

//rest api spring boot group
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobController {

    @Autowired
    private SolutionService solutionService;


    @PostMapping("/solution")
    public ResponseEntity<Solution> addSolution(@RequestBody Solution solution) { //or this can be implied by saving solution
        solutionService.addSolution(solution);
        return ResponseEntity.ok().body(solution);
    }

    @GetMapping("/solution/cateogry/{id}")
    public ResponseEntity<Result> getListSolutionByCategoryId(@PathVariable Long id) {
        Result result = new Result(); //here using result as Solution and Category are 2 different entities
        List<SolutionDTO> lst = solutionService.getSolutionByCategoryId(id);
        result.setData(lst);
        result.setStatusCode(200);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/solution")
    public ResponseEntity<SolutionDTO> checkSolutionExistByName(@RequestParam String name) throws BusinessException {
        SolutionDTO solutionDTO = solutionService.getSolutionByName(name);

        return ResponseEntity.ok(solutionDTO);
    }

    @GetMapping("/solution/{id}")
    public ResponseEntity<SolutionDTO> checkSolutionExistById(@PathVariable Long id) throws BusinessException {
        SolutionDTO solutionDTO = solutionService.getSolutionById(id);

        return ResponseEntity.ok(solutionDTO);
    }

    @PostMapping("/solution/{id}/sold/increase")
    public void increaseNumberOfCustomersUsedSolution(@PathVariable Long id)  {
        solutionService.increaseProcessedNumber(id);
    }

}
