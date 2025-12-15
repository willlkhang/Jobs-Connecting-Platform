package com.project.user.service;

import com.project.base.domain.AllowedMethod;
import com.project.base.domain.Role;
import com.project.base.domain.User;

import com.project.base.exception.RoleException;

import com.project.user.repository.UserRepository;
import com.project.user.repository.RoleRepository;
import com.project.user.repository.AllowedMethodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AllowedMethodRepository allowedMethodRepository;

    public RoleServiceImpl() {
        super();
    }

    @Override
    public List<Role> listOfRoleByUsername(String username) {
        return List.of();
    }

    @Override
    public void updateAllowedMethod(String username, Role role) throws RoleException {

    }

    @Override
    public void updateRole(String username, Role roleName) throws RoleException {

    }
}
