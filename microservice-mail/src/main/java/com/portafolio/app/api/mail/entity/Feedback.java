package com.portafolio.app.api.mail.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Feedback {

    @NotEmpty
    private String name;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String feedback;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getFeedback() {
        return feedback;
    }
}
