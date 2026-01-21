/*
* This Mapper is used for mapping input and response for other services outside job-service
* */

package com.project.job.mapper;

import com.project.base.outputDto.UserResponse;
import com.project.base.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NeighborMapper {

    UserResponse toUserResponse(User user);
}