package com.github.virtualgamers.hrtg.service;

import org.springframework.stereotype.Component;
import com.github.virtualgamers.hrtg.model.User;

@Component
public interface UserService {
    User saveByUsername(String username);

    User getUser(String username);
}
