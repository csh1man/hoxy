package com.community.hoxy.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class AuthController {
    @GetMapping("/generate-auth")
    public String generateAuth(Model model) {
        // 인증번호 생성 (6자리)
        String authCode = generateRandomAuthCode();

        // 모델에 인증번호와 문구를 추가
        model.addAttribute("authCode", authCode);
        model.addAttribute("message", "아래의 인증번호를 모바일에서 입력하시길 바랍니다.");

        return "auth"; // auth.jsp 페이지로 이동
    }

    // 랜덤한 6자리 인증번호 생성
    private String generateRandomAuthCode() {
        Random random = new Random();
        StringBuilder authCode = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            authCode.append(random.nextInt(10)); // 0부터 9까지의 랜덤한 숫자
        }
        return authCode.toString();
    }
}
