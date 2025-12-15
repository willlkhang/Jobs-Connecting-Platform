package com.project.user.repository;

import com.project.base.domain.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.id =:id")
    Role findRoleByRoleId(@Param("id") Long id);

    @Query("SELECT r FROM Role r WHERE r.roleName =:roleName")
    Role findRoleByRoleName(@Param("roleName") String roleName);
}
