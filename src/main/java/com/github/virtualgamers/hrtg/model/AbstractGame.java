package com.github.virtualgamers.hrtg.model;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractGame implements Serializable {
    private static final long serialVersionUID = 4892472236431231922L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected String id;

    @Override
    public String toString() {
        return "Game [id=" + id + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(final String Id) {
        this.id = Id;
    }
}
