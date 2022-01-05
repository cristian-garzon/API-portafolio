package com.portafolio.app.api.mail.controller;

import com.portafolio.app.api.mail.entity.Feedback;
import com.portafolio.app.api.mail.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MailController {
    @Autowired
    private IMailService mailService;

    @PostMapping("/send_mail")
    public ResponseEntity<?>  send(@Valid @RequestBody Feedback  feedback, BindingResult result) throws MessagingException {
        if(result.hasErrors()) return this.validation(result);
        mailService.send(feedback);
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
