package com.project.user.repository;

import com.project.base.domain.AllowedMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AllowedMethodRepository extends JpaRepository<AllowedMethod, Long> {

    @Query("SELECT a FROM AllowedMethod a WHERE a.methodName= :allowedMethod")
    AllowedMethod checkAllowedMethod(@Param("allowedMethod") String allowedMethod);

    @Query("SELECT r FROM AllowedMethod r WHERE r.methodName= :method")
    AllowedMethod getRoleByMethod(@Param("method") String method);
}
