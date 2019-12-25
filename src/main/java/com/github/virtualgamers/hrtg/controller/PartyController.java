package com.github.virtualgamers.hrtg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.virtualgamers.hrtg.model.User;
import com.github.virtualgamers.hrtg.service.PartyService;

@RestController("/party")
public class PartyController {
    PartyService partyService;

    public PartyController(final PartyService partyService) {
        if (partyService == null) {
            throw new IllegalStateException("PartyService cannot be null");
        }
        this.partyService = partyService;
    }

    // Setting up Party
    @GetMapping("/addToParty/{partyId}")
    public void addToParty(@RequestParam("partyId") final String partyId,
            @RequestBody final User user) {
        partyService.addToParty(partyId, user);
    }

    @GetMapping("/startParty")
    @ResponseBody
    public String startParty(@RequestBody final User user) {
        return partyService.startParty(user);
    }

}
