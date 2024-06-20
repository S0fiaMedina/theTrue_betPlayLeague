package com.thetruebetplayleague.teamMember.application;

import com.thetruebetplayleague.teamMember.application.dto.TeamMemberDTO;
import com.thetruebetplayleague.teamMember.application.userCases.CreateTeamMemberUserCase;
import com.thetruebetplayleague.teamMember.domain.repository.TeamMembeRepository;

public class TeamMemberService {

    private final TeamMembeRepository teamMembeRepository;

    //casos de uso
    private final CreateTeamMemberUserCase createTeamMemberUserCase;

    public TeamMemberService(TeamMembeRepository teamMembeRepository){
        this.teamMembeRepository = teamMembeRepository;
        this.createTeamMemberUserCase = new CreateTeamMemberUserCase(teamMembeRepository);
    }

    public void newTeamMember(TeamMemberDTO teamMemberDTO){
        this.createTeamMemberUserCase.createTeamMember(teamMemberDTO);
    }


    
}
