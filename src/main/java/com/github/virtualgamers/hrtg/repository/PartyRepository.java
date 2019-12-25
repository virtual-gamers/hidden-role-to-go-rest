package com.github.virtualgamers.hrtg.repository;

import org.springframework.data.repository.CrudRepository;
import com.github.virtualgamers.hrtg.model.Party;

public interface PartyRepository extends CrudRepository<Party, String> {
}
