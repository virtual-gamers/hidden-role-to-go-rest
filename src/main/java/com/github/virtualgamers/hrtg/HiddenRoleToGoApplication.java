package com.github.virtualgamers.hrtg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
public class HiddenRoleToGoApplication {

    public static void main(final String[] args) {
        SpringApplication.run(HiddenRoleToGoApplication.class, args);
    }

}
