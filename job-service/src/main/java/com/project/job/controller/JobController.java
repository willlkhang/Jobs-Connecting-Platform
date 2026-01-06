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
//    @Autowired
//    private SolutionMapper solutionMapper;

    @PostMapping //("add-solution")
    public ResponseEntity<Solution> addSolution(@RequestBody Solution solution) { //or this can be implied by saving solution
        solutionService.save(solution);
        return ResponseEntity.ok().body(solution);
    }

    @GetMapping("get-solutions-by-category-id")
    public ResponseEntity<Result> getListSolutionByCategoryId(@RequestParam("categoryId") Long categoryId) {
        Result result = new Result(); //here using result as Solution and Category are 2 different entities
        List<SolutionDTO> lst = solutionService.getSolutionByCategoryId(categoryId);
        result.setData(lst);
        result.setStatusCode(200);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/solutions")
    public ResponseEntity<SolutionDTO> checkSolutionExistByName(@RequestParam String name) throws BusinessException {
        SolutionDTO solutionDTO = solutionService.getSolutionByName(name);

        return ResponseEntity.ok(solutionDTO);
    }

    @GetMapping("/solutions/{id}")
    public ResponseEntity<SolutionDTO> checkSolutionExistById(@PathVariable Long id) throws BusinessException {
        SolutionDTO solutionDTO = solutionService.getSolutionById(id);

        return ResponseEntity.ok(solutionDTO);
    }

    @PostMapping("increase-number-of-customers-used-solution")
    public void increaseNumberOfCustomersUsedSolution(@RequestParam("solutionId") Long id)  {
        solutionService.increaseProcessedNumber(id);
    }

}
