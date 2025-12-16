package com.project.auth.repository;

import com.project.base.domain.AllowedMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllowedMethodRepository extends JpaRepository<AllowedMethod, Long> {
}
