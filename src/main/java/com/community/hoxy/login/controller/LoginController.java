package com.community.hoxy.login.controller;

import com.community.hoxy.login.dto.LoginRequest;
import com.community.hoxy.login.dto.TokenInfo;
import com.community.hoxy.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<TokenInfo> login(@RequestBody LoginRequest loginRequest){
        String token = loginService.createToken(loginRequest);
        return ResponseEntity.ok().body(new TokenInfo(token));
    }
}
