package com.community.hoxy.login.controller;

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
     */
    @GetMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestHeader(value="Authorization", required = true) String authorization){
        boolean tokenValidation = loginService.isValidToken(authorization);
        if(tokenValidation){
            return ResponseEntity.ok(new LoginResponse(1, "Valid Token"));
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new LoginResponse(2, "invalid token"));
        }

    }
}
