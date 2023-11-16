package com.community.hoxy.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("csh1man@koscom.co.kr");
        message.setSubject("Hoxy 인증 요청");
        message.setText("[인증번호] : [" + generateRandomAuthCode() + "]");

        mailSender.send(message);
    }

    public String generateRandomAuthCode() {
        Random random = new Random();
        StringBuilder authCode = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            authCode.append(random.nextInt(10)); // 0부터 9까지의 랜덤한 숫자
        }
        return authCode.toString();
    }
}
