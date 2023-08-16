package com.example.collegemgmt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String email,String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setFrom("aditya.parab@hey.com");
        message.setSubject("Book issued successfully");
        message.setText(text);

        mailSender.send(message);
    }
}
