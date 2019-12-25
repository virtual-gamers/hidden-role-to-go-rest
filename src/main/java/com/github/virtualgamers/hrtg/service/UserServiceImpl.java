package com.github.virtualgamers.hrtg.service;

import org.springframework.context.annotation.Primary;
import com.github.virtualgamers.hrtg.model.User;
import com.github.virtualgamers.hrtg.repository.UserRepository;

@Primary
public class UserServiceImpl implements UserService {
    UserRepository userRepository;



    public UserServiceImpl(final UserRepository userRepository) {
        if (userRepository == null) {
            throw new IllegalStateException("UserRepository cannot be null");
        }
        this.userRepository = userRepository;
    }

    @Override
    public User saveByUsername(final String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getUser(final String username) {
        // TODO Auto-generated method stub
        return null;
    }

}
