package com.thetruebetplayleague.team.application;

import java.util.Optional;


import com.thetruebetplayleague.team.application.userCases.CreateNewTeamUserCase;
import com.thetruebetplayleague.team.domain.model.Team;
import com.thetruebetplayleague.team.infrastructure.StatsTeamRepository;
import com.thetruebetplayleague.team.infrastructure.TeamRepository;

public class TeamService {
    private final TeamRepository teamRepository;
    private final StatsTeamRepository statsManager;
    private final CreateNewTeamUserCase createNewTeamUserCase;
    
    public TeamService(TeamRepository teamDAO, StatsTeamRepository statsManager){
        this.teamRepository = teamDAO;
        this.statsManager = statsManager;
        this.createNewTeamUserCase = new CreateNewTeamUserCase(this.teamRepository);

    }

    public void createNewTeam(Team team){
        createNewTeamUserCase.createTeam(team);
    }

    // informes
    public Team getTeamWithMostPoints(){
        return this.statsManager.getTeamWithMostPoints();
    }

    public Team getTeamWithMostGoals(){
        return this.statsManager.getTeamWithMostGoalsScored();
    }

    public Team getTeamWithMostWonGames(){
        return this.statsManager.getTeamWithMostWonGames();
    }

    public int getTotalOfGoals(){
        return this.statsManager.getTotalOfGoals();
    }

    public double getAverageOfGoals(){
        return this.statsManager.getAverageOfGoals();
    }



    //getters y setters
    public TeamRepository getTeamRepository() {
        return teamRepository;
    }


}
