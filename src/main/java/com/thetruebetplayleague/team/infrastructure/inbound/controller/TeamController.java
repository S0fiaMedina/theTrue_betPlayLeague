package com.thetruebetplayleague.team.infrastructure.inbound.controller;

import com.thetruebetplayleague.team.application.TeamService;
import com.thetruebetplayleague.team.application.dto.TeamDTO;
import com.thetruebetplayleague.team.domain.model.Team;
import com.thetruebetplayleague.team.domain.repository.StatsTeamRepository;
import com.thetruebetplayleague.team.domain.repository.TeamDAO;
import com.thetruebetplayleague.team.infrastructure.inbound.view.TeamView;

public class TeamController {
    
    private final TeamDAO teamDAO;
    private final StatsTeamRepository statsTeamRepository;
    TeamService teamService;
    TeamView teamView;

    public TeamController(TeamDAO teamDAO, StatsTeamRepository statsTeamRepository){
        this.teamDAO = teamDAO;
        this.statsTeamRepository = statsTeamRepository;
        this.teamService = new TeamService(this.teamDAO, this.statsTeamRepository);
        this.teamView = new TeamView();
    }
    
    
    public void run(){
        int option = teamView.menuTeam();
        Team team = null;
        switch(option){
            case 1: // crear equipo
                String name = teamView.getName();
                TeamDTO teamDTO = this.makeDTO(0, name);
                teamService.createNewTeam(teamDTO);
                break;

            case 2: // ver equipos con mas puntos
                team = teamService.getTeamWithMostPoints();
                teamView.showTeamWithMostPoints(team);
                break;

            case 3: // equipo con mas goles
                team = teamService.getTeamWithMostGoals();
                teamView.showTeamWithMostGoalsScored(team);
                break;
            
            case 4: // equipo con mas partidos ganados
                team = teamService.getTeamWithMostWonGames();
                teamView.showTeamWithMostWonGames(team);
                break;

            case 5:
                int totalGoals = teamService.getTotalOfGoals();
                teamView.showSumOfGoals(totalGoals);
                break;
            case 6:
                double avgGoals = teamService.getAverageOfGoals();
                teamView.showAvgOfGoals(avgGoals);
                break;

                
        }  
    }


    public TeamDTO makeDTO(int id, String name){
        return new TeamDTO(id, name);
    }
}