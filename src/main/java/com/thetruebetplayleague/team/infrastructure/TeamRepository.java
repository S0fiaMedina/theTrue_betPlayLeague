package com.thetruebetplayleague.team.infrastructure;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.team.domain.model.Team;

public interface TeamRepository {
    Optional<Team> findById(int id);

    List<Team> findAll();

    void save(Team team);
}
