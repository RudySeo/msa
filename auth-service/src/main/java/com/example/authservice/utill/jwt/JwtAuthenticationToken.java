package com.example.authservice.utill.jwt;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * JWT 인증 객체를 담당하는 클래스로 인증된 사용자의 정보를 가지고 있다.
 */
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal; // 인증된 사용자를 식별할 수 있는 정보

    public JwtAuthenticationToken(
        Object principal, Collection<? extends GrantedAuthority> authorities
    ) {
        super(authorities);
        super.setAuthenticated(true);

        this.principal = principal;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}
