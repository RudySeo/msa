package com.example.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.CsrfSpec;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
            .csrf(CsrfSpec::disable) // csrf 비활성화
            .authorizeExchange(exchanges -> exchanges
                .pathMatchers("/login", "/register").permitAll() // 로그인 및 회원가입 경로는 인증 없이 접근 가능
                .anyExchange().authenticated() // 그 외의 모든 경로는 인증 필요
            )
            .build();
    }
}
