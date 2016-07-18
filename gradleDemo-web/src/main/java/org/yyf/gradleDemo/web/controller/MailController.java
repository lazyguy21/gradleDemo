package org.yyf.gradleDemo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tobi on 16-7-14.
 */
@RestController
@RequestMapping("mail")
public class MailController {
    @Autowired
    JavaMailSenderImpl mailSender;
    @RequestMapping("send")
    public void send(){
        sendEmail();
    }
    @Async
    private void sendEmail(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        // 设置收件人，寄件人 用数组发送多个邮件
        // String[] array = new String[] {"sun111@163.com","sun222@sohu.com"};
        // mailMessage.setTo(array);
        mailMessage.setTo("");
        mailMessage.setFrom("");
        mailMessage.setSubject(" 测试简单文本邮件发送！ ");
        mailMessage.setText(" 测试我的简单邮件发送机制！！ ");
        mailSender.send(mailMessage);
    }
}
