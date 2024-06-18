package com.thetruebetplayleague.team.domain.repository;

import java.util.List;

import com.thetruebetplayleague.team.domain.model.Team;

public interface TeamDAO {
    Team findById(int id);

    List<Team> findAll();

    void save(Team team);
}
