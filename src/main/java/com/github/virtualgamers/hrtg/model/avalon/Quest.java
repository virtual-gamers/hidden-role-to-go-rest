package com.github.virtualgamers.hrtg.model.avalon;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;
    int number;
    String crown;
    boolean lancelotFlipped;
    String ladyOfTheLake;
    String laked;
    @OneToMany
    List<Player> onMission;
    @OneToMany
    List<Player> successes;
    @OneToMany
    List<Player> failures;
    @OneToMany
    List<Player> rejects;
    @OneToMany
    List<Player> approves;
}
