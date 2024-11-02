package com.example.authservice.controller;

import com.example.authservice.dto.LoginRequest;
import com.example.authservice.dto.RegisterRequest;
import com.example.authservice.dto.TokenResponse;
import com.example.authservice.model.User;
import com.example.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterRequest request) {
        log.info("Registering user: {}", request);
        User user = authService.registerUser(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {
        String token = authService.login(request);
        return ResponseEntity.ok(new TokenResponse(token));
    }
}
