package com.portafolio.app.api.skill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceSkillApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceSkillApplication.class, args);
    }

}
