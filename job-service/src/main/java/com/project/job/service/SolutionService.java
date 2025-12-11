package com.project.job.service;

import com.project.base.dto.SolutionDTO;
import com.project.job.domain.Solution;

import java.util.List;

public interface SolutionService {

    List<SolutionDTO> getServiceByName(String solutionName);

    void save(Solution solution);

    void delete(Solution solution);

    SolutionDTO getServiceById(Long id);

    void increaseProcessedNumber(Long id);
    void decreaseProcessedNumber(Long id);
}
