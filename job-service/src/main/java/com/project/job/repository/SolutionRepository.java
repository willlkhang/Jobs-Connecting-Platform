package com.project.job.repository;

import com.project.job.domain.Solution;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SolutionRepository extends JpaRepository<Solution, Integer> {

    @Query("SELECT s FROM Solution  s JOIN s.categories c WHERE c.categoryId =:categoryId")
    List<Solution> getSolutionByCategoryId(@Param("categoryId") Long categoryId);

    @Query("SELECT s FROM  Solution s WHERE s.solutionName =:solutionName")
    Solution getSolutionByName(@Param("solutionName") String solutionName);

    @Query("SELECT s FROM Solution s WHERE s.solutionId =:solutionId")
    Solution getSolutionsById(@Param("solutionId") Long id);

    //The query which interrupts the data such as update requires these 2 annotations
    @Transactional
    @Modifying
    @Query(value = "UPDATE Solution s SET s.processedNumber = (s.processedNumber + 1) WHERE s.solutionId =:solutionId")
    void increaseProcessedNumber(@Param("solutionId") Long solutionId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Solution s SET s.processedNumber = (s.processedNumber + 1) WHERE s.solutionId =:solutionId")
    void updateProcessedNumber(@Param("solutionId") Long solutionId);
}
