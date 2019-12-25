package com.github.virtualgamers.hrtg.model.avalon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KnowledgeUser extends KnowledgeRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private final String username;

    public KnowledgeUser(final KnowledgeRole knowledgeRole, final String username) {
        super(knowledgeRole.getRole(), knowledgeRole.getKnowledge());
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
