package com.portafolio.app.api.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicioMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioMailApplication.class, args);
    }

}
