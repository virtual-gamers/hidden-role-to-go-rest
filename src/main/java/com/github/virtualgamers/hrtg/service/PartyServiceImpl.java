package com.github.virtualgamers.hrtg.service;

import java.util.Optional;
import java.util.Random;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import com.github.virtualgamers.hrtg.model.Party;
import com.github.virtualgamers.hrtg.model.User;
import com.github.virtualgamers.hrtg.repository.PartyRepository;

@Component
@Primary
public class PartyServiceImpl implements PartyService {
    PartyRepository partyRepository;
    UserService userService;
    Random random = new Random();
    String partyIdCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    int partyIdSize = 5; // partyIdCharacters ^ partyIdSize = 36 ^ 5 = 60+mill combinations

    @Override
    public void addToParty(final String partyId, final User user) {
        final Party party = getParty(partyId);
        party.addUser(user);
        partyRepository.save(party);
    }

    @Override
    public Party getParty(final String partyId) {
        final Optional<Party> optional = partyRepository.findById(partyId);
        if (!optional.isPresent()) {
            throw new IllegalStateException("No Party exists with partyId=" + partyId);
        }
        return optional.get();
    }

    @Override
    public String startParty(final User user) {
        final Party party = new Party(user);
        party.setId(genPartyId());
        final Party persisted = partyRepository.save(party);
        return persisted.getId();
    }

    private String genPartyId() {
        String partyId = "";
        for (int i = 0; i < partyIdSize; i++) {
            partyId += partyIdCharacters.charAt(random.nextInt(partyIdCharacters.length()));
        }
        return partyId;
    }
}
