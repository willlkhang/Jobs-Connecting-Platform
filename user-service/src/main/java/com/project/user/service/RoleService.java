package com.project.user.service;

import com.project.base.domain.Role;
import com.project.base.exception.RoleException;

import java.util.List;

public interface RoleService {

    void updateRole(String username, Role roleName) throws RoleException;

    void updateAllowedMethod(String username, Role role) throws RoleException;

    List<Role> listOfRoleByUsername(String username);
}