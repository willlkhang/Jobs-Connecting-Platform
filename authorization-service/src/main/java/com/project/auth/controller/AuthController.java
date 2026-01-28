package com.project.auth.controller;

import com.project.auth.service.AllowedMethodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private AllowedMethodService allowedMethodService;

    @GetMapping(value = "/get-ACL")
    public ResponseEntity<Map<String, String>> getACL() {
        return ResponseEntity.ok(allowedMethodService.getAllowedMethodsWithRoles());
    }
}
