package com.project.job.mapper;

import com.project.base.dto.CategoryDTO;
import com.project.base.outputDto.CategoryResponse;
import com.project.base.summaryDto.SolutionSummaryDTO;
import com.project.job.domain.Category;
import com.project.job.domain.Solution;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse toResponse(Category category);

    SolutionSummaryDTO toSummary(Solution solution);
}