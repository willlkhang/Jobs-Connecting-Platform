package com.project.job.repository;

import com.project.job.domain.Category;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c")
    List<Category> getAllCategory();

    @Query("SELECT c FROM Category c WHERE c.categoryId =:categoryId")
    Category getCategoryById(@Param("categoryId") Long categoryId);
}
