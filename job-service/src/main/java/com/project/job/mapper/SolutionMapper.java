package com.project.job.mapper;

import com.project.base.dto.CategoryDTO;
import com.project.base.dto.SolutionDTO;
import com.project.base.outputDto.SolutionResponse;
import com.project.job.domain.Category;
import com.project.job.domain.Solution;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface SolutionMapper {

    //tell map struct to map the categories list in the entity to CategoryID in DTO
    //Note the categories is solution.categories
    //entity -> IDs
    //Json returns [id1, id2,...]
    @Mapping(source = "categories", target = "categoryIds", qualifiedByName = "mapCategoriesToIds")
    SolutionDTO entityToDTO(Solution solution);

    //entity -> full object.
    //this is used for sending info to FE
    SolutionResponse toResponse(Solution solution);

    //category -> categoryDTO
    CategoryDTO toCategoryDTO(Category category);

    @Named("mapCategoriesToIds")
    default List<Long> mapCategoriesToIds(Set<Category> categories) {
        if(categories == null) {
            return null;
        }

        return categories.stream().map(Category::getCategoryId).collect(Collectors.toList());
    }
}
