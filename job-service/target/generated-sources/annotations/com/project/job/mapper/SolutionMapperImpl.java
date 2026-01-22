package com.project.job.mapper;

import com.project.base.dto.CategoryDTO;
import com.project.base.dto.SolutionDTO;
import com.project.base.outputDto.SolutionResponse;
import com.project.job.domain.Category;
import com.project.job.domain.Solution;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-21T18:03:22+1030",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Ubuntu)"
)
@Component
public class SolutionMapperImpl implements SolutionMapper {

    @Override
    public SolutionDTO entityToDTO(Solution solution) {
        if ( solution == null ) {
            return null;
        }

        SolutionDTO solutionDTO = new SolutionDTO();

        solutionDTO.setCategoryIds( mapCategoriesToIds( solution.getCategories() ) );
        solutionDTO.setImageUrl( solution.getImageUrl() );
        solutionDTO.setSolutionId( solution.getSolutionId() );
        solutionDTO.setUserId( solution.getUserId() );
        solutionDTO.setSolutionName( solution.getSolutionName() );
        solutionDTO.setDescription( solution.getDescription() );
        solutionDTO.setPrice( solution.getPrice() );
        solutionDTO.setProcessedNumber( solution.getProcessedNumber() );

        return solutionDTO;
    }

    @Override
    public SolutionResponse toResponse(Solution solution) {
        if ( solution == null ) {
            return null;
        }

        SolutionResponse solutionResponse = new SolutionResponse();

        solutionResponse.setImageUrl( solution.getImageUrl() );
        solutionResponse.setSolutionId( solution.getSolutionId() );
        solutionResponse.setCategories( categorySetToCategoryDTOSet( solution.getCategories() ) );
        solutionResponse.setProcessedNumber( solution.getProcessedNumber() );
        solutionResponse.setDescription( solution.getDescription() );
        solutionResponse.setPrice( solution.getPrice() );
        solutionResponse.setSolutionName( solution.getSolutionName() );

        return solutionResponse;
    }

    @Override
    public CategoryDTO toCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setCategoryId( category.getCategoryId() );
        categoryDTO.setCategoryName( category.getCategoryName() );
        categoryDTO.setDescription( category.getDescription() );

        return categoryDTO;
    }

    protected Set<CategoryDTO> categorySetToCategoryDTOSet(Set<Category> set) {
        if ( set == null ) {
            return null;
        }

        Set<CategoryDTO> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( Category category : set ) {
            set1.add( toCategoryDTO( category ) );
        }

        return set1;
    }
}
