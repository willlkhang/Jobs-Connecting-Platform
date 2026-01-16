package com.project.job.service;

import com.project.base.dto.BookingEvent;
import com.project.base.dto.SolutionDTO;
import com.project.job.domain.Solution;

import java.util.List;

public interface SolutionService {

    List<Solution> getAllSolution();

    List<SolutionDTO> getSolutionByCategoryId(Long CategoryId);

    //basic save delete group
    void addSolution(Solution solution);
    void delete(Solution solution);

    //fetching group
    SolutionDTO getSolutionByName(String solutionName);
    SolutionDTO getSolutionById(Long id);

    //number updating group
    void increaseProcessedNumber(Long id);
    //void decreaseProcessedNumber(Long id);

    void updateSolution(BookingEvent bookingEvent);
}
