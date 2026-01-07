package com.project.user.controller;

import com.project.base.domain.AllowedMethod;
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
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findUserByUserId(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserByUserName(@RequestParam("name") String username){
        User user = userRepository.findUserByUsername(username);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/user/register")
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

    @GetMapping("/user/roles/")
    public ResponseEntity<?> getUserRoleByUsername(@RequestParam("username") String username) {
        return ResponseEntity.ok(roleService.listOfRoleByUsername(username));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/user/admin/assign/{userId}/to/{roleId}")
    public ResponseEntity<?> setRoleForUser(@PathVariable Long userId,
                                            @PathVariable Long roleId) {
        User user = userRepository.findUserByUserId(userId);
        Role role = roleRepository.findRoleByRoleId(roleId);

        if(user != null && role != null) {
            user.getRoles().add(role);
            userService.saveUser(user);
            return ResponseEntity.ok().body(user);
        }
        else return ResponseEntity.ok("User or role is not on database");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/user/admin/assign/methods/role")
    public ResponseEntity<?> assignMethodsToRole(@RequestParam("method") String methodName,
                                                 @RequestParam("role") String roleName) {
        roleService.updateAllowedMethod(methodName, roleName);

        return ResponseEntity.ok("Assign Successfully");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/user/admin/update/roles/user")
    public ResponseEntity<?> updateRolesForUser(@RequestParam("username") String username,
                                                @RequestParam("role") String roleName)
            throws RuntimeException {

        Role role = roleRepository.findRoleByRoleName(roleName);
        roleService.updateRole(username, role);

        return ResponseEntity.ok("Update Successfully");
    }
}
