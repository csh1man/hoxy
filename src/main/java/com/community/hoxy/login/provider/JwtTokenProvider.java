package com.community.hoxy.login.provider;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    private String secretKey;
    private long validityInMs;

    public JwtTokenProvider(){
        this.secretKey ="TEST";
        this.validityInMs = 30000L;
    }

    public String createToken(String subject){
        Claims claims = Jwts.claims().setSubject(subject);
        Date now = new Date();

        Date validity = new Date(now.getTime() + validityInMs);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String getSubject(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try{
            /* jwt의 서명 검증을 수행하고 서명 검증에 실패할 시 JwtException 발생 */
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            /* jwt의 유효기간 검증 프로세스 수행. */
            if(claims.getBody().getExpiration().before(new Date())){
                return false;
            }
        }catch(JwtException | IllegalArgumentException e){
            return false;
        }
        return true;
    }
}
