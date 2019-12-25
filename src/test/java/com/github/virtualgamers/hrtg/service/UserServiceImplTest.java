package com.github.virtualgamers.hrtg.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.github.virtualgamers.hrtg.repository.UserRepository;

@EnableJpaRepositories
@SpringBootTest
public class UserServiceImplTest {
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Before
    public void before() {
        // userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void testSaveByUsername() {}
}
