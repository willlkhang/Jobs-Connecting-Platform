package com.project.job.service;

import com.project.base.dto.SolutionDTO;

import com.project.job.domain.Solution;
import com.project.job.mapper.SolutionMapper;
import com.project.job.repository.ServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionServiceImpl implements SolutionService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private SolutionMapper solutionMapper;

    @Override
    public List<SolutionDTO> getServiceByName(String serviceName) {
        return List.of();
    }

    @Override
    public void save(Solution solution) {

    }

    @Override
    public void delete(Solution solution) {

    }

    @Override
    public SolutionDTO getServiceById(Long id) {
        return null;
    }

    @Override
    public void decreaseProcessedNumber(Long id) {

    }

    @Override
    public void increaseProcessedNumber(Long id) {

    }
}
