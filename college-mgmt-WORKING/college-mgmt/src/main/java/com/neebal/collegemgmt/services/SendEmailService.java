//package com.neebal.collegemgmt.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//@Service
//@Async
//public class SendEmailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    public void sendEmail(String email, String text){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(email);
//        message.setFrom("adparab97@gmail.com");
//        message.setSubject("Book issued successfully");
//        message.setText(text);
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        //mailSender.send(message);
//        System.out.println("Email sent to: " + email);
//    }
//}
