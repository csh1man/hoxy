package com.community.hoxy.login.controller;

import com.community.hoxy.exception.dto.SimpleResponse;
import com.community.hoxy.exception.msg.ExceptionCode;
import com.community.hoxy.login.dto.LoginRequest;
import com.community.hoxy.login.dto.LoginResponse;
import com.community.hoxy.login.dto.TokenInfo;
import com.community.hoxy.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 클라이언트에서 접근 토큰 발급 요청이 들어오면 접근 토큰 발급 후 반환
     * @param loginRequest id/pwd 정보가 들어있는 Request데이터
     */
    @PostMapping("/login/access-token")
    public ResponseEntity<TokenInfo> getAccessToken(@RequestBody LoginRequest loginRequest){
        String token = loginService.createToken(loginRequest);
        return ResponseEntity.ok().body(new TokenInfo(token));
    }

    /**
     * 로그인 시도
     * @param authorization 발급받은 토큰 값
     * @param loginRequest 아이디/패스워드 정보
     */
    @PostMapping("/login")
    public ResponseEntity<SimpleResponse> login(@RequestHeader(value="Authorization", required = true) String authorization, @RequestBody LoginRequest loginRequest){
        SimpleResponse tokenValidation = loginService.isValidToken(loginRequest.getId(), authorization);
        return ResponseEntity.status(tokenValidation.getRspCode()).body(tokenValidation);
    }
}
