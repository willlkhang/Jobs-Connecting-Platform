package com.project.user.service;

import com.project.base.domain.User;
import com.project.base.outputDto.UserResponse;
import com.project.user.mapper.UserMapper;
import com.project.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> userEntities = userRepository.getAllUser();

        return userEntities.stream().map(a -> userMapper.toResponse(a)).collect(Collectors.toList());
    }

    @Override
    public boolean isDuplicatedUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        return user != null;
    }
    @Override
    public boolean isDuplicatedEmail(String email) {
        User user = userRepository.findUserByUserEmail(email);
        return user != null;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserByUserId(Long userId) {
        return userRepository.findUserByUserId(userId);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
