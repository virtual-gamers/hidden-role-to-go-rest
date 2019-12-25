package com.github.virtualgamers.hrtg.service.avalon;

import org.springframework.stereotype.Component;

@Component
public interface AvalonService {

    void forceLancelotToFlip(String gameId);

    void lake(String gameId, String usernameOfLaker, String usernameOfLaked);

    void putOnQuest(String gameId, String[] usernames, boolean confirm);

    void questVote(String gameId, String username, boolean approvedQuest);

    void questAction(String gameId, String username, boolean succeededQuest);
}
