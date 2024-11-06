package com.example.apigateway.Utils.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final Key key;
//    private final long accessTokenExpTime;
//    private final long refreshTokenExpTime;

    public JwtUtil(
        @Value("${jwt.secret}") String SECRET
//        @Value("${jwt.access_expiration_time}") long accessTokenExpirationTime,
//        @Value("${jwt.refresh_expiration_time}") long refreshTokenExpirationTime
    ) {
        byte[] decodeKey = Decoders.BASE64.decode(SECRET); // 비밀 키 값을 디코딩
        this.key = Keys.hmacShaKeyFor(decodeKey); // SHA 키 생성
//        this.accessTokenExpTime = accessTokenExpirationTime;
//        this.refreshTokenExpTime = refreshTokenExpirationTime;
    }

    // 토큰을 파싱하여 클레임을 추출
    public Jws<Claims> validateToken(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token);
    }
}
