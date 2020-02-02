package com.github.virtualgamers.hrtg.rest.controller.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.virtualgamers.hrtg.core.model.Party;
import com.github.virtualgamers.hrtg.core.model.User;
import com.github.virtualgamers.hrtg.core.service.PartyService;

/**
 * API for the {@link PartyService}
 *
 * @author CCThomas
 *
 */
@RestController
@RequestMapping("/party")
public class PartyController {

    Logger logger = LoggerFactory.getLogger(PartyController.class);

    @Autowired
    PartyService partyService;

    @PostMapping("/addToParty/{partyId}/{username}")
    public User addToParty(@PathVariable("partyId") final String partyId,
            @PathVariable("username") final String username) {
        logger.info("Adding to Party. partyId=" + partyId + ", and username=" + username);
        return partyService.addToParty(partyId, username);
    }

    @GetMapping("/getParty/{partyId}")
    public Party getParty(@PathVariable("partyId") final String partyId) {
        logger.info("Getting Party with partyId=" + partyId);
        return partyService.getParty(partyId);
    }

    @PostMapping("/startParty/{username}")
    public Party startParty(@PathVariable("username") final String username) {
        logger.info("Starting a Party. username=" + username);
        return partyService.startParty(username);
    }
}
