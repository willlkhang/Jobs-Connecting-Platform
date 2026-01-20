package com.project.base.outputDto;

import com.project.base.summaryDto.SolutionSummaryDTO;

import java.util.Set;

public class CategoryResponse {

    private Long categoryId;
    private String categoryName;
    private String description;

    //passing solutionSummary instead of solutionDTO avoid recursion loop
    private Set<SolutionSummaryDTO> solutions;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<SolutionSummaryDTO> getSolutions() {
        return solutions;
    }

    public void setSolutions(Set<SolutionSummaryDTO> solutions) {
        this.solutions = solutions;
    }
}