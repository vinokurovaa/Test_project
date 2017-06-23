package com.springmvc.services;

import com.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;

    public void sendEmail(Object object) {
        final User user = (User)object;
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

                helper.setSubject("Autorization");
                helper.setFrom("oooenglishlearn@gmail.com");
                helper.setTo(user.getEmail());

                String content = "Dear " + user.getFirstName() + user.getLastName() + ", " + "Thank you for your registration";
                helper.setText("<html><body><p>" + content + "</body></html>", true);
            }
        };
        try {
            mailSender.send(preparator);
        }catch (MailException ex){
            System.err.println(ex.getMessage());
        }
    }
}
