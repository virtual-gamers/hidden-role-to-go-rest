package com.github.virtualgamers.hrtg.model;

import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Party {
    @Id
    String id;
    String partyLeaderUserId;
    LinkedList<AbstractUser> users;
    AbstractGame game;

    public Party(final User user) {
        this.partyLeaderUserId = user.getUsername();
        this.users = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getPartyLeaderUserId() {
        return partyLeaderUserId;
    }

    public void setPartyLeaderUserId(final String partyLeaderUserId) {
        this.partyLeaderUserId = partyLeaderUserId;
    }

    public LinkedList<AbstractUser> getUsers() {
        return users;
    }

    public void setUsers(final LinkedList<AbstractUser> users) {
        this.users = users;
    }


    public void addUser(final User user) {
        users.add(user);
    }
}
