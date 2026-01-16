package com.project.job.service;

import com.project.job.domain.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAllById(Long categoryId);
}
