package com.project.user.controller;

import com.project.base.domain.Role;
import com.project.base.domain.User;

import com.project.user.dto.UserSignUp;

import com.project.user.service.UserService;
import com.project.user.service.RoleService;

import com.project.user.repository.UserRepository;
import com.project.user.repository.RoleRepository;
import com.project.user.repository.AllowedMethodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.crypto.password.PasswordEncoder;

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

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/get-user-by-id")
    public ResponseEntity<User> getUserById(@RequestParam("userId") Long id) {
        User user = userService.findUserByUserId(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/get-user-by-username")
    public ResponseEntity<User> getUserByUserName(@RequestParam("username") String username){
        User user = userRepository.findUserByUsername(username);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/register-new-user")
    public ResponseEntity<?> registerNewUser(@RequestBody UserSignUp userSignUp) {
        if (!userService.isDuplicatedEmail(userSignUp.getEmail()) &&
            !userService.isDuplicatedUsername(userSignUp.getUsername())) {

            User user = new User();
            user.setEmail(userSignUp.getEmail());
            user.setUsername(userSignUp.getUsername());
            user.setPassword(passwordEncoder.encode(userSignUp.getPassword()));
            user.setUserType(userSignUp.getUserType());
            user.setFullName(userSignUp.getFullName());
            user.setPhone(userSignUp.getPhone());

            userService.saveUser(user);
            return ResponseEntity.ok().body(user);
        }
        else{
            return ResponseEntity.ok("This Username or email is already exited");
        }
    }

    @GetMapping("/get-user-role-by-username")
    public ResponseEntity<?> getUserRoleByUsername(@RequestParam("username") String username) {
        return ResponseEntity.ok(roleService.listOfRoleByUsername(username));
    }
}
