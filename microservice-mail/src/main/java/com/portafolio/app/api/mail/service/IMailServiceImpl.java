package com.portafolio.app.api.mail.service;

import com.portafolio.app.api.mail.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class IMailServiceImpl implements IMailService{


    @Autowired
    private JavaMailSender sender;

    @Autowired
    private Environment env;

    @Override
    public void send(Feedback feedback) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setFrom(env.getProperty("spring.mail.username"));
        helper.setTo(feedback.getEmail());
        helper.setText("hey " + feedback.getName() + " thanks for visit my website :D, my name is cristian" +
                ", nice to meet you, so tell me, what do you need? i would like to know :3");
        helper.setSubject("cristian garzón web developer");
        FileSystemResource file = new FileSystemResource(new File("E:/programacion/api-portafolio/microservice-mail/src/main/java/com/portafolio/app/api/mail/service/CRISTIAN-GARZON.pdf"));
        helper.addAttachment(file.getFilename(),file);
        sender.send(message);

    }


}
