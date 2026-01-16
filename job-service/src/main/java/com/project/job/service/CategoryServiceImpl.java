package com.project.job.service;

import com.project.job.domain.Category;
import com.project.job.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.getAllCategory();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.getCategoryById(categoryId);
    }
}
