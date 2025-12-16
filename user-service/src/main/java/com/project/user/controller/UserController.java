package com.project.user.controller;

import com.project.base.domain.Role;
import com.project.base.domain.User;

import com.project.user.service.UserService;
import com.project.user.service.RoleService;

import com.project.user.repository.UserRepository;
import com.project.user.repository.RoleRepository;
import com.project.user.repository.AllowedMethodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleService roleService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AllowedMethodRepository allowedMethodRepository;

    @GetMapping("get-user-by-id")
    public ResponseEntity<User> getUserById(@RequestParam("userId") Long id) {
        User user = userService.findUserByUserId(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

}
