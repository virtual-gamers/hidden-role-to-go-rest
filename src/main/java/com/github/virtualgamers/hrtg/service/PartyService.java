package com.github.virtualgamers.hrtg.service;

import org.springframework.stereotype.Component;
import com.github.virtualgamers.hrtg.model.Party;
import com.github.virtualgamers.hrtg.model.User;

/**
 * {@link PartyService} sets up a {@link Party}
 *
 * @author CCThomas
 *
 */
@Component
public interface PartyService {

    /**
     * Add {@link User} with userId to {@link Party} with partyId
     *
     * @param partyId for a {@link Party}
     * @param user {@link User}
     */
    void addToParty(String partyId, User user);

    /**
     * Gets a {@link Party} by partyId
     *
     * @param partyId
     * @return {@link Party}
     */
    Party getParty(String partyId);

    /**
     * Starts a Game Party
     *
     * @param user {@link User}
     * @return {@link String} partyId
     */
    String startParty(User user);
}
