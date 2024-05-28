package com.portkeeper.pkbackend.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Properties;

@Service
public class PortServiceMappingEmailSender {
    @Value("${senderEmail}")
    private String senderEmail;

    @Value("${receiverEmail}")
    private String receiverEmail;

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(PortServiceMapping portServiceMapping){
        Properties properties = new Properties();
        SimpleMailMessage message = new SimpleMailMessage();
        String datetime = new java.util.Date().toString();
        String body   =  "Service Description: %s\n IP Address: %s\n Port Number: %s\n Time of Outage: %s\n Current Status: The service is currently down.\n\n".formatted(portServiceMapping.getAssociateService(),portServiceMapping.getServiceIpAddress(),portServiceMapping.getServicePortNumber(), datetime);

        message.setFrom(senderEmail);
        message.setTo(receiverEmail);

        message.setSubject("Server Down " + portServiceMapping.getServiceIpAddress() + ":" + portServiceMapping.getServicePortNumber());
        message.setText(body);

        mailSender.send(message);
        System.out.println("Mail Sent Successfully...");
    }
}
