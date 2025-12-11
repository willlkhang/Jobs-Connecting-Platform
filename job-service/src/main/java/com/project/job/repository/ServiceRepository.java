package com.project.job.repository;

import com.project.job.domain.Solution;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Solution, Integer> {

    @Query("SELECT s FROM Solution s JOIN s.categories c WHERE c.categoryId =:categoryId")
    List<Solution> getSolutionByCategoryId(@Param("categoryId") Long categoryId);

    @Query("SELECT s FROM  Solution s WHERE s.serviceName =:serviceName")
    List<Solution> getSolutionByName(@Param("solutionName") String solutionName);

    //The query which interrupts the data such as update requires these 2 annotations
    @Transactional
    @Modifying
    @Query(value = "UPDATE Solution s SET s.processedNumber = (s.processedNumber + 1) WHERE s.solutionId =:serviceId")
    void increaseProcessedNumber(@Param("solutionId") Integer serviceId, @Param("processedNumber") Integer processedNumber);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Solution s SET s.processedNumber = (s.processedNumber - 1) WHERE s.solutionId =:solutionId")
    void decreaseProcessedNumber(@Param("solutionId") Integer serviceId, @Param("processedNumber") Integer processedNumber);
}
