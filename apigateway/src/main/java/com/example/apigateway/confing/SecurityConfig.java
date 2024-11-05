//package com.example.apigateway.confing;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//            .formLogin(AbstractHttpConfigurer::disable)
//            .csrf(AbstractHttpConfigurer::disable)
//            .httpBasic(AbstractHttpConfigurer::disable)
//            .sessionManagement(
//                sessionManagement -> sessionManagement.sessionCreationPolicy(
//                    SessionCreationPolicy.STATELESS))
//            .authorizeHttpRequests((authorizeRequests) -> authorizeRequests
//                .requestMatchers("/auth/**").permitAll()
//                .anyRequest().permitAll()
//            )
//            .build();
//    }
//}
