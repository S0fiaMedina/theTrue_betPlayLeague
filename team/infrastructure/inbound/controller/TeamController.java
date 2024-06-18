package com.thetruebetplayleague.team.infrastructure.inbound.controller;

import com.thetruebetplayleague.team.application.TeamService;
import com.thetruebetplayleague.team.application.dto.TeamDTO;
import com.thetruebetplayleague.team.domain.repository.TeamDAO;
import com.thetruebetplayleague.team.infrastructure.inbound.view.TeamView;

public class TeamController {
    
    private final TeamDAO teamDAO;
    TeamService teamService;
    TeamView teamView;

    public TeamController(TeamDAO teamDAO){
        this.teamDAO = teamDAO;
        this.teamService = new TeamService(this.teamDAO);
        this.teamView = new TeamView();
    }
    
    
    public void run(){
        while (true){
            int option = teamView.menuTeam();
            if (option == 1){
                String name = teamView.getName();
                TeamDTO teamDTO = this.makeDTO(0, name);
                teamService.createNewTeam(teamDTO);
            } else{
                break;
            }

        }
    }


    public TeamDTO makeDTO(int id, String name){
        return new TeamDTO(id, name);
    }
}