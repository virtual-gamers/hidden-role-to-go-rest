package com.github.virtualgamers.hrtg.model.avalon;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import com.github.virtualgamers.hrtg.model.AbstractUser;

@Entity
@SecondaryTable(name = "USER_TABLE")
public class Player extends AbstractUser {
    private static final long serialVersionUID = 5320394539120547776L;
    private final String userId;
    private Role role;
    private Alignment alignment;
    private boolean flipped;
    @OneToMany
    private List<KnowledgeUser> knowledgeUser;

    public Player(final AbstractUser user) {
        super(user.getUsername());
        this.userId = user.getId();
    }

    public List<KnowledgeUser> getKnowledgeUser() {
        return knowledgeUser;
    }

    public void setKnowledgeUser(final List<KnowledgeUser> knowledgeUser) {
        this.knowledgeUser = knowledgeUser;
    }

    public String getUserId() {
        return userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(final Alignment alignment) {
        this.alignment = alignment;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void setFlipped(final boolean flipped) {
        this.flipped = flipped;
    }
}
