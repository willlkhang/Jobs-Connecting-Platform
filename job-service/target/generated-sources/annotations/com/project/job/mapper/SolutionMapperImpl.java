package com.project.job.mapper;

import com.project.base.dto.SolutionDTO;
import com.project.job.domain.Category;
import com.project.job.domain.Solution;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-15T02:53:58+1030",
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

        solutionDTO.setCategoryIds( categorySetToLongList( solution.getCategories() ) );
        solutionDTO.setSolutionId( solution.getSolutionId() );
        solutionDTO.setUserId( solution.getUserId() );
        solutionDTO.setSolutionName( solution.getSolutionName() );
        solutionDTO.setDescription( solution.getDescription() );
        solutionDTO.setPrice( solution.getPrice() );
        solutionDTO.setProcessedNumber( solution.getProcessedNumber() );

        return solutionDTO;
    }

    protected List<Long> categorySetToLongList(Set<Category> set) {
        if ( set == null ) {
            return null;
        }

        List<Long> list = new ArrayList<Long>( set.size() );
        for ( Category category : set ) {
            list.add( mapCategoryToId( category ) );
        }

        return list;
    }
}
