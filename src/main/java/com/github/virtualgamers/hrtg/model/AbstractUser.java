package com.github.virtualgamers.hrtg.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * https://stackoverflow.com/questions/2700680/table-per-subclass-inheritance-relationship-how-to-query-against-the-parent-cla/3017146#3017146
 *
 * @author ccthom94
 *
 */
@MappedSuperclass
public abstract class AbstractUser implements Serializable {
    private static final long serialVersionUID = 4892472236431231922L;

    @Id
    @GeneratedValue
    private String id;

    @Column(table = "USER_TABLE")
    String username;

    public AbstractUser(final String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
}

