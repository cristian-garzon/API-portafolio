package com.portafolio.app.api.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceMailApplication.class, args);
    }

}
