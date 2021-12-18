package com.portafolio.app.api.mail.controller;

import com.portafolio.app.api.mail.entity.Feedback;
import com.portafolio.app.api.mail.service.IMailService;
import com.portafolio.app.api.mail.service.IMailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailController {
    @Autowired
    private IMailService mailService;

    @GetMapping("/send")
    void  send(@RequestBody Feedback  feedback) throws MessagingException {
        mailService.send(feedback);
    }
}
