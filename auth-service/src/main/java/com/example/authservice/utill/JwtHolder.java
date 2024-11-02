package com.example.authservice.utill;

import com.example.authservice.model.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;

@Slf4j
@RequiredArgsConstructor
public class JwtHolder {

    private final String errorMessage = "jwt claim 필드 null : ";
    private final Jws<Claims> claims;
    @Getter
    private final String token;
    private List<GrantedAuthority> authorities;

    public Long getUserId() {
        try {
            String userId = claims.getBody().get(JwtProperties.USER_ID).toString();
            return Long.parseLong(userId);
        } catch (NullPointerException e) {
            log.info(errorMessage + JwtProperties.USER_ID);
            throw new IllegalArgumentException();
        }
    }

    public boolean isAccessToken() {
        return isRightToken(JwtProperties.ACCESS_TOKEN_NAME);
    }

    public boolean isRefreshToken() {
        return isRightToken(JwtProperties.REFRESH_TOKEN_NAME);
    }

    private boolean isRightToken(String tokenType) {
        try {
            return claims.getHeader().get(JwtProperties.TOKEN_TYPE).toString().equals(tokenType);
        } catch (NullPointerException e) {
            log.info(errorMessage + tokenType);
            throw new IllegalArgumentException();
        }
    }

    public Date getExpirationTime() {
        return claims.getBody().getExpiration();
    }

    public Role getRole() {
        try {
            String role = claims.getBody().get(JwtProperties.ROLE).toString();
            return Role.valueOf(role);
        } catch (NullPointerException e) {
            log.info(errorMessage + JwtProperties.ROLE);
            throw new IllegalArgumentException();
        }
    }
}


