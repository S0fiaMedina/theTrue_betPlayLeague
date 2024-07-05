package com.thetruebetplayleague.Modules.team.infrastructure;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.team.domain.Team;



public interface TeamRepository {

    public Optional<Team> findById(int id);

    public List<Team> findAll();

    public void update(Team Team);

    public void save(Team Team);

    public void delete(int id);
    
}
