package com.community.hoxy.login.provider;

import com.community.hoxy.exception.dto.SimpleResponse;
import com.community.hoxy.exception.msg.ExceptionCode;
import com.community.hoxy.exception.msg.ExceptionMsg;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    private String secretKey;
    private String issuer = "HOXY PROJECT";
    private String subject;
    private long validityInMs;

    public JwtTokenProvider(){
        this.secretKey ="TEST";
        this.validityInMs = 30000L;
    }

    public String createToken(String subject){
        Claims claims = Jwts.claims()
                            .setSubject(subject)
                            .setIssuer(issuer);
        Date now = new Date();

        Date validity = new Date(now.getTime() + validityInMs);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    /**
     * 발행 대상자의 정보를 토큰에서 획득
     * @param token jwt token
     */
    public String getSubject(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * 토근 발행기관 정보 획득
     * @param token jwt token
     */
    public String getIssuer(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getIssuer();
    }

    /**
     * 토큰 검증 과정 수행
     * @param id 사용자 아이디
     * @param token
     */
    public SimpleResponse isValidToken(String id, String token){
        /* 서명 및 유효성 거증 */
        SimpleResponse signingAndDateValidResult = isValidSigningAndDate(token);
        if(signingAndDateValidResult.getRspCode() != ExceptionCode.SUCCESS.getCode()){
            return signingAndDateValidResult;
        }
        /* 토큰 발행기관 검증 */
        SimpleResponse isValidIssuer = isValidIssuer(token);
        if(isValidIssuer.getRspCode() != ExceptionCode.SUCCESS.getCode()){
            return isValidIssuer;
        }

        /* 토큰 발행 대상자 검증 */
        SimpleResponse isValidSubject = isValidSubject(id, token);
        if(isValidSubject.getRspCode() != ExceptionCode.SUCCESS.getCode()){
            return isValidSubject;
        }

        return new SimpleResponse(ExceptionCode.SUCCESS.getCode(), ExceptionMsg.SUCCESS.getMsg());
    }

    /**
     * 토큰 서명값 검증 및 유효기간 검증 수행
     * @param token
     */
    public SimpleResponse isValidSigningAndDate(String token){
        try{
            /* jwt의 서명 검증을 수행하고 서명 검증에 실패할 시 JwtException 발생 */
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            /* jwt의 유효기간 검증 프로세스 수행. */
        }catch(ExpiredJwtException e){
            return new SimpleResponse(ExceptionCode.JWT_DATE_EXPIRED.getCode(), ExceptionMsg.JWT_DATE_EXPIRED.getMsg());
        }catch(SignatureException e){
            return new SimpleResponse(ExceptionCode.JWT_INVALID_SIGNING.getCode(), ExceptionMsg.JWT_INVALID_SIGNING.getMsg());
        }
        return new SimpleResponse(ExceptionCode.SUCCESS.getCode(), ExceptionMsg.SUCCESS.getMsg());
    }

    /**
     * 발급기관 검증
     * @param token jwt token
     */
    public SimpleResponse isValidIssuer(String token){
        String issuer = getIssuer(token);
        if(!this.issuer.equals(issuer)){
            return new SimpleResponse(ExceptionCode.JWT_INVALID_ISSUER.getCode(), ExceptionMsg.JWT_INVALID_ISSUER.getMsg());
        }
        return new SimpleResponse(ExceptionCode.SUCCESS.getCode(), ExceptionMsg.SUCCESS.getMsg());
    }

    /**
     * 발급 대상 검증
     * @param id 발급대상 계정 정보
     * @param token jwt token
     */
    public SimpleResponse isValidSubject(String id, String token){
        String subject = getSubject(token);
        if(!id.equals(subject)){
            return new SimpleResponse(ExceptionCode.JWT_INVALID_SUBJECT.getCode(), ExceptionMsg.JWT_INVALID_SUBJECT.getMsg());
        }
        return new SimpleResponse(ExceptionCode.SUCCESS.getCode(), ExceptionMsg.SUCCESS.getMsg());
    }
}
