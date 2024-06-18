package com.thetruebetplayleague.teamMember.infrastructure.inbound.controller;

import com.thetruebetplayleague.teamMember.infrastructure.inbound.view.TeamMemberView;

public class TeamMemberController {
    TeamMemberView teamMemberView;

    public TeamMemberController(){
        teamMemberView = new TeamMemberView();
    }

    public void run(){
        while(true){
            int op = teamMemberView.teamMemberMenu();
            if (op == 1){
               TeamMemberDTO teamMemberDTO = teamMemberView.getDataOfTeamMember(); //  obtiene todos los datos y los recibe enn froma de dto
                
                // manda a su respectivo controlador
                if (teamMemberDTO.getRol().equals("Jugador")){

                } else if(teamMemberDTO.getRol().equals("Tecnico")){

                } else{
                    
                }
            } else{
                break;
            }
        }
        
    }
}
