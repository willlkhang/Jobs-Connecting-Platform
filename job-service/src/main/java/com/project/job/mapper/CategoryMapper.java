package com.project.job.mapper;

import com.project.base.outputDto.CategoryResponse;
import com.project.base.summaryDto.SolutionSummaryDTO;
import com.project.job.domain.Category;
import com.project.job.domain.Solution;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryMapper {

    //map Category -> CategoryResponse
    CategoryResponse toResponse(Category category);

    SolutionSummaryDTO toSummary(Solution solution);
}