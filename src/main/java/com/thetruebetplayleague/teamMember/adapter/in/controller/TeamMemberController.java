package com.thetruebetplayleague.teamMember.adapter.in.controller;

import com.thetruebetplayleague.teamMember.adapter.in.view.TeamMemberView;
import com.thetruebetplayleague.teamMember.application.TeamMemberService;
import com.thetruebetplayleague.teamMember.application.dto.TeamMemberDTO;
import com.thetruebetplayleague.teamMember.domain.model.TeamMember;
import com.thetruebetplayleague.teamMember.infrastructure.TeamMembeRepository;

public class TeamMemberController {
    private final TeamMemberView teamMemberView;
    private final TeamMembeRepository teamMembeRepository;
    private final TeamMemberService teamMemberService;

    public TeamMemberController(TeamMembeRepository teamMembeRepository){
        teamMemberView = new TeamMemberView();
        this.teamMembeRepository = teamMembeRepository;
        this.teamMemberService = new TeamMemberService(teamMembeRepository);

    }

    public void run(){
        while(true){
            int op = teamMemberView.teamMemberMenu();
            if (op == 1){
                String name = teamMemberView.getName();
                String lastName = teamMemberView.getLastName();
                int idTeam = teamMemberView.getTeamId();
                int idNacionality = teamMemberView.getNationality();
                String rol = teamMemberView.getRol();
                TeamMemberDTO dto = this.makeDTO(0, idTeam, name, lastName, idNacionality, rol);
                this.teamMemberService.newTeamMember(dto);


                if (rol.equals("Tecnico")){

                } else if (rol.equals("Medico")){

                } else if (rol.equals("Jugador")){

                }
            }
        }
    }


    public TeamMemberDTO makeDTO(int id, int idTeam, String name, String lastName, int idNacionality, String rol){
        return new TeamMemberDTO(id, idTeam, name, lastName, idNacionality, rol);
    }

 
}
