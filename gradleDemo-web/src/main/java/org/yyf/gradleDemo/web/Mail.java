package org.yyf.gradleDemo.web;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by tobi on 16-7-14.
 */
public class Mail {
    public static void main(String[] args) {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//        javaMailSender.setHost("smtp.qq.com");
        javaMailSender.setHost("smtp.exmail.qq.com");
        javaMailSender.setPort(25);
        // 建立邮件消息
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        // 设置收件人，寄件人 用数组发送多个邮件
        // String[] array = new String[] {"sun111@163.com","sun222@sohu.com"};
        // mailMessage.setTo(array);
        mailMessage.setTo("yinfei.ye@.com");
        mailMessage.setFrom("yinfei.ye@qq.com");
        mailMessage.setSubject(" 测试简单文本邮件发送！ ");
        mailMessage.setText(" 测试我的简单邮件发送机制！！ ");

        javaMailSender.setUsername("yinfei.ye@qq.com"); // 根据自己的情况,设置username
        javaMailSender.setPassword("sdf"); // 根据自己的情况, 设置password


        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
        prop.put("mail.smtp.timeout", "1000");
        javaMailSender.setJavaMailProperties(prop);
        // 发送邮件
        javaMailSender.send(mailMessage);

        System.out.println(" 邮件发送成功.. ");
    }
}
