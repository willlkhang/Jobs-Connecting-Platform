package com.project.job.mapper;

import com.project.base.outputDto.CategoryResponse;
import com.project.base.summaryDto.SolutionSummaryDTO;
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
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryResponse toResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setCategoryId( category.getCategoryId() );
        categoryResponse.setCategoryName( category.getCategoryName() );
        categoryResponse.setDescription( category.getDescription() );
        categoryResponse.setSolutions( solutionSetToSolutionSummaryDTOSet( category.getSolutions() ) );

        return categoryResponse;
    }

    @Override
    public SolutionSummaryDTO toSummary(Solution solution) {
        if ( solution == null ) {
            return null;
        }

        SolutionSummaryDTO solutionSummaryDTO = new SolutionSummaryDTO();

        solutionSummaryDTO.setImageUrl( solution.getImageUrl() );
        solutionSummaryDTO.setSolutionId( solution.getSolutionId() );
        solutionSummaryDTO.setSolutionName( solution.getSolutionName() );
        solutionSummaryDTO.setPrice( solution.getPrice() );

        return solutionSummaryDTO;
    }

    protected Set<SolutionSummaryDTO> solutionSetToSolutionSummaryDTOSet(Set<Solution> set) {
        if ( set == null ) {
            return null;
        }

        Set<SolutionSummaryDTO> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( Solution solution : set ) {
            set1.add( toSummary( solution ) );
        }

        return set1;
    }
}
