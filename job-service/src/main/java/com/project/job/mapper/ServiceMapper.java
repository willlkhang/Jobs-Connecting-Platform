package com.project.job.mapper;

import com.project.base.dto.ServiceDTO;
import com.project.job.domain.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    @Mapping(source = "category.categoryId", target = "categoryId")
    ServiceDTO toServiceDTO(Service service);

}
