package com.github.virtualgamers.hrtg.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Contains just the contents of the Super Class
 *
 * @author ccthom94
 *
 */
@Entity
@Table(name = "USER_TABLE")
@AttributeOverrides({@AttributeOverride(name = "username", column = @Column(name = "username"))})
public class User extends AbstractUser {
    private static final long serialVersionUID = 9026634825672560400L;

    public User(final String username) {
        super(username);
    }
}
