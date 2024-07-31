package com.backendforfooddelci.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.backendforfooddelci.Entity.RegisterUser;

@Service
public class SendMailService implements EmailService {

    @Autowired
    private JavaMailSender mailSender;
    
    @Value("${spring.mail.username}")
    private String fromEmail;
    
    private static final Logger logger = LoggerFactory.getLogger(SendMailService.class);

    @Override
    public void sendEmail(RegisterUser user) {
        String name = user.getUserName();
        String email = user.getEmail();
        String appName = "Delfoodaap";
        String subject = "Welcome to Delfoodaap - Your Account is Ready!";
        
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome, ").append(name).append("!\n\n");
        sb.append("Congratulations on creating your account with ").append(appName).append("!\n");
        sb.append("We're excited to have you join us and look forward to serving you.\n\n");
        sb.append("Best regards,\n");
        sb.append("The ").append(appName).append(" Team");
        
        String message = sb.toString();
        
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(fromEmail); // Set the sender email address
            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(message);
            
            mailSender.send(simpleMailMessage);
            logger.info("Email sent successfully to {}", email);
        } catch (Exception e) {
            logger.error("Failed to send email to {}: {}", email, e.getMessage());
            // Handle exception as needed (e.g., log error, throw custom exception)
        }
    }
}
