package com.project.job.service;

import com.project.base.outputDto.CategoryResponse;
import com.project.job.domain.Category;
import com.project.base.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    void addCategory(CategoryDTO categoryDTO);

    Category getCategoryById(Long categoryId);

    public List<CategoryResponse> getAllCategories();
}
