package com.github.virtualgamers.hrtg.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "GAME_TABLE")
public class Game extends AbstractGame {
    private static final long serialVersionUID = -4401779531220790370L;
}
