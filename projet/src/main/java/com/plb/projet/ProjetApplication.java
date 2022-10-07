package com.plb.projet;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;
public class ProjetApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ProjetApplication.class);
        ConfigurableEnvironment environment = new StandardEnvironment();
        environment.setDefaultProfiles("dev");
        application.setEnvironment(environment);
        application.run(args);
    }

}
