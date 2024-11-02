package com.example.authservice.utill.jwt;

import com.example.authservice.utill.JwtHolder;
import java.util.Date;
import lombok.Getter;

@Getter
public class JwtAuthentication {

    private final String token;
    private final Long id;
    private final Date expirationTime;

    public JwtAuthentication(JwtHolder jwtHolder) {
        this.token = jwtHolder.getToken();
        this.id = jwtHolder.getUserId();
//        this.role = jwtHolder.getRole();
        this.expirationTime = jwtHolder.getExpirationTime();
    }
}
