package com.community.hoxy.mail.controller;

import com.community.hoxy.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 회사 메일 인증을 위한 로직 처리 컨트롤러
 */
@Controller
public class MailController {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MailService mailService;
    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 메일 주소를 클라이언트에서 넘겨줬을 때 인증번호 메일을 발송하는 로직
     * @param email 클라이언트에서 전송한 인증이 필요한 메일 주소
     */
    @GetMapping("/sendAuthMail")
    public void sendAuthMail(@RequestParam String email) throws MessagingException {
        System.out.println("이메일 주소 : [" + email + "]");
        /**
         * MimeMessage 객체
         * - 자바메일 API에서 이메일을 표현하는 데 사용.
         * - 이메일 주소, 내용, 수신자, 참조자를 설정할 수 있음.
         * - 이메일에 첨부할 첨부파일을 설정할 수 있음.
         * - 이메일 전송기능까지 존재
         */
        MimeMessage message = mailSender.createMimeMessage();
        /**
         * MimeMessageHelper 객체
         * - 스프링프레임워크에서 제공
         * - MimeMessage 객체를 조작하고 구성하는 객체
         */
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(email);
        helper.setSubject("[Hoxy Project] 인증번호 발송");

        /**
         * Context 객체
         * 탬플릿엔진에 사용될 즉, 변수를 지정하여 화면에 뿌릴 프론트 코드에 동적 변수의 값을 전달하는 데 주로 사용
         */
        Context context = new Context();
        System.out.println("인증번호 :[" + mailService.generateRandomAuthCode()+"]");
        context.setVariable("verificationCode", mailService.generateRandomAuthCode());
        String htmlContent = templateEngine.process("sendAuthMail", context);

        /* HTML 이메일 내용 설정 */
        helper.setText(htmlContent, true);

        mailSender.send(message);
    }
}
