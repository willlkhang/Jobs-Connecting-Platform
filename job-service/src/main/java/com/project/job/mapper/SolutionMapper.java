package com.project.job.mapper;

import com.project.base.dto.SolutionDTO;
import com.project.job.domain.Category;
import com.project.job.domain.Solution;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SolutionMapper {

    //tell map struct to map the categories list in the entity to CategoryID in DTO
    //Note the categories is solution.categories
    @Mapping(source = "categories", target = "categoryIds")
    SolutionDTO entityToDTO(Solution solution);

    default Long mapCategoryToId(Category category) {
        if (category == null) {
            return null;
        }
        return category.getCategoryId();
    }

}
