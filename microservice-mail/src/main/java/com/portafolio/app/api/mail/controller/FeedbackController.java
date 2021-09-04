package com.portafolio.app.api.mail.controller;

import com.portafolio.app.api.mail.MailConfig;
import com.portafolio.app.api.mail.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FeedbackController {

    @Autowired
    private MailConfig mailConfig;


    @PostMapping("/send")
    public ResponseEntity<?> SendFeedBack(@Valid @RequestBody Feedback feedback, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) return this.validation(bindingResult);
        //config mail server
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(mailConfig.getHost());
        sender.setPort(mailConfig.getPort());
        sender.setUsername(mailConfig.getUsername());
        sender.setPassword(mailConfig.getPassword());

        //create mail
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(feedback.getEmail());
        message.setTo("cristiancamilogarzon@ucundinamarca.edu.co");
        message.setSubject("new mail for job from " + feedback.getName());
        message.setText(feedback.getFeedback());


        // send mail
        sender.send(message);
        return ResponseEntity.noContent().build();
    }
    protected ResponseEntity<?> validation(BindingResult result){
        Map<String, Object> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "the camp " + err.getField() + " " +err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
