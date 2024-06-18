package com.thetruebetplayleague.team.application.userCases;

import com.thetruebetplayleague.team.application.dto.TeamDTO;
import com.thetruebetplayleague.team.domain.model.Team;
import com.thetruebetplayleague.team.domain.repository.TeamDAO;

public class CreateNewTeamUserCase {
    TeamDAO teamDAO;

    public CreateNewTeamUserCase(TeamDAO teamDAO){
        this.teamDAO = teamDAO;
    }


    public void createTeam(TeamDTO teamDTO){
        Team team = TeamDTO.toDomainModel(teamDTO);
        this.teamDAO.save(team);
        
    }
}
