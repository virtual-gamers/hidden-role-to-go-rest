package com.github.virtualgamers.hrtg.controller;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api")
public class HelloWorldController {
    @GetMapping
    public String root() {
        return "The time at the server is now " + new Date() + "\n";
    }
}
