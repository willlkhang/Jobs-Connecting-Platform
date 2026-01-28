package com.project.user.mapper;

import com.project.base.domain.User;
import com.project.base.outputDto.UserResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-28T14:37:45+1030",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Ubuntu)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( user.getId() );
        userResponse.setUsername( user.getUsername() );

        return userResponse;
    }
}
