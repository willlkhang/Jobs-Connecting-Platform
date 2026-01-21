package com.project.base.outputDto;

import com.project.base.dto.CategoryDTO;

import java.math.BigDecimal;
import java.util.Set;

public class SolutionResponse {

    private Long solutionId;
    //private Long userId;
    private UserResponse user;
    private String solutionName;
    private String description;
    private BigDecimal price;
    private Integer processedNumber;
    //sending info to FE
    private Set<CategoryDTO> categories;
    private String imageUrl;

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

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

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDTO> categories) {
        this.categories = categories;
    }

    public Integer getProcessedNumber() {
        return processedNumber;
    }

    public void setProcessedNumber(Integer processedNumber) {
        this.processedNumber = processedNumber;
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

    public String getSolutionName() {
        return solutionName;
    }

    public void setSolutionName(String solutionName) {
        this.solutionName = solutionName;
    }

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
}
