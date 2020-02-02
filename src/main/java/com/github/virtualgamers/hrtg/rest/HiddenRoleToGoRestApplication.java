package com.github.virtualgamers.hrtg.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.github.virtualgamers.hrtg.core.model")
@EnableJpaRepositories("com.github.virtualgamers.hrtg.core.repository")
@ComponentScan({ //
        "com.github.virtualgamers.hrtg.rest.controller.core", //
        "com.github.virtualgamers.hrtg.core.service", //
        "com.github.virtualgamers.hrtg.core.publisher", //
        "com.github.virtualgamers.hrtg.rest"})
public class HiddenRoleToGoRestApplication {
    public static void main(final String[] args) {
        SpringApplication.run(HiddenRoleToGoRestApplication.class, args);
    }
}
