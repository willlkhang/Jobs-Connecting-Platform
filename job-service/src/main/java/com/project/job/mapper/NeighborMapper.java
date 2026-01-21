/*
* This Mapper is used for mapping input and response for other services outside job-service
* */

package com.project.job.mapper;

import com.project.base.outputDto.UserResponse;
import com.project.base.domain.User;
import org.mapstruct.Mapper;
import org.springframework.http.ResponseEntity;

@Mapper(componentModel = "spring")
public interface NeighborMapper {

    UserResponse toUserResponse(ResponseEntity<User> user);
}