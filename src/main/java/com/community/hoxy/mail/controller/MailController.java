package com.community.hoxy.mail.controller;

import com.community.hoxy.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Controller
public class MailController {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MailService mailService;
    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("/sendMessage")
    public void sendMessage() throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("csh1man@koscom.co.kr");
        helper.setSubject("[혹시] 인증 요청 ");

        // HTML 템플릿을 읽어와 이메일 내용으로 설정합니다.
        // HTML 템플릿을 읽어옵니다.
        Context context = new Context();
        context.setVariable("verificationCode", mailService.generateRandomAuthCode());
        String htmlContent = templateEngine.process("emailAuthCode", context);

        // HTML 이메일 내용을 설정합니다.
        helper.setText(htmlContent, true);

        mailSender.send(message);
    }
}
