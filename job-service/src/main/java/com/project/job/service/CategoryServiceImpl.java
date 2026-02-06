package com.project.job.service;

import com.project.base.dto.CategoryDTO;
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
    public void addCategory(CategoryDTO categoryDTO) {
        try {
            Category category = new Category();
            //category.setCategoryId(categoryDTO.getCategoryId());
            category.setCategoryName((categoryDTO.getCategoryName()));
            category.setDescription((categoryDTO.getDescription()));

            categoryRepository.save(category);
        }
        catch (Exception e) {
            System.out.println("Some thing is missing from category input");
        }
    }

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
