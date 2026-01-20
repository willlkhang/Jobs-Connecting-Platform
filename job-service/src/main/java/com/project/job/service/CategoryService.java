package com.project.job.service;

import com.project.base.outputDto.CategoryResponse;
import com.project.job.domain.Category;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(Long categoryId);

    public List<CategoryResponse> getAllCategories();
}
