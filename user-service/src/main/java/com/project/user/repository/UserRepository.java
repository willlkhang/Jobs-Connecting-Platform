package com.project.user.repository;

import com.project.base.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username =:username")
    User findUserByUsername(@Param("userName") String username);

    @Query("SELECT u FROM User u WHERE u.email =:email")
    User findUserByUserEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.id =:id")
    User findUserByUserId(@Param("id") Long userId);
}
