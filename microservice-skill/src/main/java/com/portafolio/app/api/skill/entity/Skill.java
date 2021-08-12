package com.portafolio.app.api.skill.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @JsonIgnore
    private byte[] image;

    private Long progressBar;

    public Integer getImageHashCode(){
        return (this.image != null) ? this.image.hashCode() : null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setProgressBar(Long progressBar) {
        this.progressBar = progressBar;
    }

    public Long getId() {
        return id;
    }

    public byte[] getImage() {
        return image;
    }

    public Long getProgressBar() {
        return progressBar;
    }
}
