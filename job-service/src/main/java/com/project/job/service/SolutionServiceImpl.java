package com.project.job.service;

import com.project.base.dto.BookingEvent;
import com.project.base.dto.BookingDTO;
import com.project.base.dto.SolutionDTO;
import com.project.base.exception.BusinessException;

import com.project.job.domain.Solution;
import com.project.job.mapper.SolutionMapper;
import com.project.job.repository.SolutionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public List<SolutionDTO> getSolutionByCategoryId(Long categoryId) {
        List<Solution> lst = solutionRepository.getSolutionByCategoryId(categoryId);
        List<SolutionDTO> lstDTO = lst.stream().map(a -> solutionMapper.entityToDTO(a)).collect(Collectors.toList());
        return lstDTO;
    }

    @Override
    public SolutionDTO getSolutionByName(String solutionName) {
        List<Solution> solutionList = solutionRepository.getSolutionByName(solutionName);
        List<SolutionDTO> lstDTO = solutionList.stream().map(a -> solutionMapper.entityToDTO(a)).collect(Collectors.toList());

        if(!lstDTO.isEmpty())
            return lstDTO.get(0);
        else
            System.out.println("Searching for solution with name: '" + solutionName + "'");
            throw new BusinessException("Solution not found");
    }

    @Override
    public SolutionDTO getSolutionById(Long id) {
        List<Solution> solutionList = solutionRepository.getSolutionsById(id);
        List<SolutionDTO> lstDTO = solutionList.stream().map(a -> solutionMapper.entityToDTO(a)).collect(Collectors.toList());

        if(!lstDTO.isEmpty())
            return lstDTO.get(0);
        else
            throw new BusinessException("Solution not found");
    }

    @Override
    public void increaseProcessedNumber(Long id) {
        solutionRepository.increaseProcessedNumber(id);
    }

    @Override
    public void updateSolution(BookingEvent booking) {
        BookingDTO bookingDTO = booking.getBooking();
        //this may or may not contain nullable value
        Optional<Solution> solution = solutionRepository.getSolutionsById(bookingDTO.get)
    }
}
