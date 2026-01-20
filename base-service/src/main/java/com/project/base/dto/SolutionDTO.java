package com.project.base.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class SolutionDTO {

    private Long solutionId;
    private Long userId;

    private List<Long> categoryIds;

    private String solutionName;
    private String description;
    private BigDecimal price;
    private Integer processedNumber;

    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Long solutionId) {
        this.solutionId = solutionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public String getSolutionName() {
        return solutionName;
    }

    public void setSolutionName(String solutionName) {
        this.solutionName = solutionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getProcessedNumber() {
        return processedNumber;
    }

    public void setProcessedNumber(Integer processedNumber) {
        this.processedNumber = processedNumber;
    }
}