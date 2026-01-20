package com.project.job.service;

import com.project.base.outputDto.CategoryResponse;

import com.project.job.domain.Category;
import com.project.job.mapper.CategoryMapper;
import com.project.job.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                            .map(categoryMapper::toResponse)
                            .collect(Collectors.toList());
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.getCategoryById(categoryId);
    }
}
