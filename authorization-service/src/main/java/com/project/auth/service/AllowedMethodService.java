package com.project.auth.service;

import com.project.auth.repository.AllowedMethodRepository;

import com.project.base.domain.AllowedMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AllowedMethodService {

    @Autowired
    AllowedMethodRepository allowedMethodRepository;

    public Map<String, String> getAllowedMethodsWithRoles() {
        return allowedMethodRepository
                .findAll()
                .stream()
                .collect(Collectors.toMap(
                        AllowedMethod::getMethodName,
                        AllowedMethod::getRoles
                ));
    }
}
