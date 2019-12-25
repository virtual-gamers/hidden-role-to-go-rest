package com.github.virtualgamers.hrtg.model.avalon;

public class KnowledgeRole {
    private final Role role;
    private final Knowledge knowledge;

    public KnowledgeRole(final Role role, final Knowledge knowledge) {
        this.role = role;
        this.knowledge = knowledge;
    }

    public Role getRole() {
        return role;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }

}
