package com.project.job.service;

import com.project.base.dto.SolutionDTO;

import com.project.job.domain.Solution;
import com.project.job.mapper.SolutionMapper;
import com.project.job.repository.SolutionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolutionServiceImpl implements SolutionService {

    @Autowired
    private SolutionRepository solutionRepository;

    @Autowired
    private SolutionMapper solutionMapper;


    @Override
    public void save(Solution solution) {
        solutionRepository.save(solution);
    }

    @Override
    public void delete(Solution solution) {
        solutionRepository.delete(solution);
    }

    @Override
    public List<Solution> getSolutionByCategoryId(Long CategoryId) {
        return List.of();
    }

    @Override
    public SolutionDTO getSolutionByName(String solutionName) {
        List<Solution> solutionList = solutionRepository.getSolutionByName(solutionName);
        List<SolutionDTO> lstDTO = solutionList.stream().map(a -> solutionMapper.entityToDTO(a)).collect(Collectors.toList());

        if(lstDTO.isEmpty()):
            return lstDTO.get(0);
        else:
            throw new
    }

    @Override
    public SolutionDTO getSolutionById(Long id) {
        return null;
    }

    @Override
    public void decreaseProcessedNumber(Long id) {

    }

    @Override
    public void increaseProcessedNumber(Long id) {

    }
}
