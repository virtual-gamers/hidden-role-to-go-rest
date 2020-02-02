package com.github.virtualgamers.hrtg.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.virtualgamers.hrtg.core.repository.PartyRepository;
import com.github.virtualgamers.hrtg.core.repository.UserRepository;

/**
 * root passw0rd
 *
 * @author ccthom94
 *
 */
@Component
public class DatabaseLoader {
    @Autowired
    PartyRepository partyRepository;

    @Autowired
    UserRepository userRepository;


    public DatabaseLoader() {}
}
