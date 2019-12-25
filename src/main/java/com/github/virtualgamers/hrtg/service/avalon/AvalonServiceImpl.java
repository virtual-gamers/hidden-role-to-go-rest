package com.github.virtualgamers.hrtg.service.avalon;

import java.util.Optional;
import com.github.virtualgamers.hrtg.model.avalon.Avalon;
import com.github.virtualgamers.hrtg.repository.PartyRepository;
import com.github.virtualgamers.hrtg.repository.UserRepository;
import com.github.virtualgamers.hrtg.repository.avalon.AvalonRepository;
import com.github.virtualgamers.hrtg.repository.avalon.PlayerRepository;

public class AvalonServiceImpl implements AvalonService {

    PartyRepository partyRepository;
    PlayerRepository playerRepository;
    AvalonRepository avalonRepository;
    UserRepository userRepository;

    public AvalonServiceImpl(final PartyRepository partyRepository,
            final PlayerRepository playerRepository, final AvalonRepository avalonRepository,
            final UserRepository userRepository) {
        if (partyRepository == null) {
            throw new IllegalStateException("PartyRepository cannot be null");
        }
        if (playerRepository == null) {
            throw new IllegalStateException("PlayerRepository cannot be null");
        }
        if (avalonRepository == null) {
            throw new IllegalStateException("PartyRepository cannot be null");
        }
        if (userRepository == null) {
            throw new IllegalStateException("UserRepository cannot be null");
        }
        this.partyRepository = partyRepository;
        this.avalonRepository = avalonRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void forceLancelotToFlip(final String gameId) {
        getAvalon(gameId);
    }

    @Override
    public void lake(final String gameId, final String usernameOfLaker,
            final String usernameOfLaked) {
        // TODO Auto-generated method stub

    }

    @Override
    public void putOnQuest(final String gameId, final String[] usernames, final boolean confirm) {
        // TODO Auto-generated method stub

    }

    @Override
    public void questVote(final String gameId, final String username, final boolean approvedQuest) {
        // TODO Auto-generated method stub

    }

    @Override
    public void questAction(final String gameId, final String username,
            final boolean succeededQuest) {
        // TODO Auto-generated method stub
    }

    private Avalon getAvalon(final String gameId) {
        final Optional<Avalon> optional = avalonRepository.findById(gameId);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("No Game exists for gameId=" + gameId);
        }
        return optional.get();
    }
}
