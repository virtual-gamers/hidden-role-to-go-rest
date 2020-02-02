package com.github.virtualgamers.hrtg.rest.controller.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.virtualgamers.hrtg.core.model.User;
import com.github.virtualgamers.hrtg.core.service.UserService;

/**
 * API for the {@link UserService}
 * 
 * @author CCThomas
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping(path = "/getUser/{partyId}/{username}", produces = "application/json")
    public User getUser(@PathVariable("partyId") final String partyId,
            @PathVariable("username") final String username) {
        logger.info("Getting a User by partyId=" + partyId + " and username=" + username);
        final User user = userService.getUser(partyId, username);

        logger.info("Retrieved user=" + user);
        return user;
    }
}
