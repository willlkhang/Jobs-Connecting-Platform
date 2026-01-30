package com.project.auth.controller;

import com.project.auth.service.AllowedMethodService;

import com.project.base.loginDto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class AuthController {

//    private final RestTemplate restTemplate = new RestTemplate();
//
//    @Value("${app.oauth-url}")
//    private String oauthTokenUrl;
//
//    @Value("${spring.security.oauth2.resourceserver.jwt.client-id:client}")
//    private String clientId;
//
//    @Value("${spring.security.oauth2.resourceserver.jwt.client-secret:secret}")
//    private String clientSecret;

    @Autowired
    private AllowedMethodService allowedMethodService;


//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//        String url = this.oauthTokenUrl;
//
//        //prepare as setting up in Postman
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.setBasicAuth(clientId, clientSecret);
//
//        return null;
//    }

    @GetMapping(value = "/get-ACL")
    public ResponseEntity<Map<String, String>> getACL() {
        return ResponseEntity.ok(allowedMethodService.getAllowedMethodsWithRoles());
    }
}
