package com.project.auth.controller;

import com.project.auth.service.AllowedMethodService;

import com.project.base.loginDto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
