package com.thetruebetplayleague.team.application.userCases;

import com.thetruebetplayleague.team.domain.model.Team;
import com.thetruebetplayleague.team.infrastructure.TeamRepository;

public class CreateNewTeamUserCase {
    TeamRepository teamDAO;

    public CreateNewTeamUserCase(TeamRepository teamDAO){
        this.teamDAO = teamDAO;
    }


    public void createTeam(Team team){
        this.teamDAO.save(team);
        
    }
}
