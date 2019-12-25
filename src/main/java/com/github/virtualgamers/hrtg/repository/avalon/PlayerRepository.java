package com.github.virtualgamers.hrtg.repository.avalon;

import org.springframework.data.repository.CrudRepository;
import com.github.virtualgamers.hrtg.model.avalon.Player;

public interface PlayerRepository extends CrudRepository<Player, String> {
}
