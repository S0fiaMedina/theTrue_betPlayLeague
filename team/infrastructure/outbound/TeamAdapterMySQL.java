package com.thetruebetplayleague.team.infrastructure.outbound;

import java.util.List;

import com.thetruebetplayleague.team.domain.model.Team;
import com.thetruebetplayleague.team.domain.repository.TeamDAO;

public class TeamAdapterMySQL  implements TeamDAO{
    @Override
    public List<Team> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Team findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Team team) {
        // TODO Auto-generated method stub
        
    }
}
