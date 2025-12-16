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

    @Override
    public List<Role> listOfRoleByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        return user.getRoles().stream().collect(Collectors.toList());
    }

    @Override
    public void updateAllowedMethod(String methodName, String role) throws RoleException {
        AllowedMethod allowedMethod = allowedMethodRepository.checkAllowedMethod(methodName);

        //if there is no method, add it
        if(allowedMethod == null) {
            allowedMethod = new AllowedMethod();
            allowedMethod.setMethodName(methodName);
        }
        else{
            String[] str = role.split(",");

            for (String s : str){
                if(!checkRoleExists(s)){
                    String result = String.format("Role %s does not exist", s);
                    throw new RoleException(result);
                }
            }
        }

        allowedMethod.setRoles(role);
        allowedMethodRepository.save(allowedMethod);
    }

    @Override
    public void updateRole(String username, Role roleName) throws RoleException {
        User user = userRepository.findUserByUsername(username);

        if(user.getRoles().contains(roleName)){
            throw new RoleException("Role is already existed");
        }
        else {
            user.getRoles().add(roleName);
            userRepository.save(user);
        }
    }

    @Override
    public boolean checkRoleExists(String roleName) {
        Role role = roleRepository.findRoleByRoleName(roleName);
        if (role != null)
            return true;
        else
            return false;
    }
}
