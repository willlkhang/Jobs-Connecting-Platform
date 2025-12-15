package com.project.user.service;

import com.project.base.domain.User;
import com.project.user.dto.UserSignUp;

public interface UserService {

    User findUserByUsername(String username);
    User findUserByUserId(Long userId);

    void saveUser(User user);

    boolean isDuplicatedEmail(String email);
    boolean isDuplicatedUsername(String username);
}
