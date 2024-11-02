package com.example.authservice.service;

import com.example.authservice.dto.LoginRequest;
import com.example.authservice.dto.RegisterRequest;
import com.example.authservice.model.User;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.utill.JWTUtil;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final JWTUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public User registerUser(RegisterRequest request) {
//        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
//            throw new RuntimeException("Username is already taken");
//        }
        log.info("Registering user: {}", request);
        User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .build();

        return userRepository.save(user);
    }

    @Transactional
    public String login(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());

        if (userOpt.isPresent() && passwordEncoder.matches(request.getPassword(),
            userOpt.get().getPassword())) {
            return jwtUtil.createToken(userOpt.get().getUsername());
        }

        throw new RuntimeException("Invalid credentials");
    }
}
