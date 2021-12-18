package com.portafolio.app.api.mail.service;

import com.portafolio.app.api.mail.entity.Feedback;

import javax.mail.MessagingException;

public interface IMailService {
    public void send(Feedback feedback) throws MessagingException;
}
