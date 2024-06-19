package com.thetruebetplayleague.team.application;

import com.thetruebetplayleague.team.application.dto.TeamDTO;
import com.thetruebetplayleague.team.application.userCases.CreateNewTeamUserCase;
import com.thetruebetplayleague.team.domain.model.Team;
import com.thetruebetplayleague.team.domain.repository.StatsTeamRepository;
import com.thetruebetplayleague.team.domain.repository.TeamDAO;

public class TeamService {
    private final TeamDAO teamRepository;
    private final StatsTeamRepository statsManager;
    private TeamDTO teamDTO;

    private CreateNewTeamUserCase createNewTeamUserCase;
    
    public TeamService(TeamDAO teamDAO, StatsTeamRepository statsManager){
        this.teamRepository = teamDAO;
        this.statsManager = statsManager;
        this.createNewTeamUserCase = new CreateNewTeamUserCase(this.teamRepository);

    }

    public void createNewTeam(TeamDTO teamDTO){
        createNewTeamUserCase.createTeam(teamDTO);
    }

    public Team getTeamWithMostPoints(){
        return this.statsManager.getTeamWithMostPoints();
    }

    public int getTotalOfGoals(){
        return this.statsManager.getTotalOfGoals();
    }

    public double getAverageOfGoals(){
        return this.statsManager.getAverageOfGoals();
    }



    //getters y setters
    public TeamDAO getTeamRepository() {
        return teamRepository;
    }

    public TeamDTO getTeamDTO() {
        return teamDTO;
    }

    public void setTeamDTO(TeamDTO teamDTO) {
        this.teamDTO = teamDTO;
    }



    



}
