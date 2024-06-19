package com.thetruebetplayleague.teamMember.application.userCases;

import com.thetruebetplayleague.teamMember.application.dto.TeamMemberDTO;
import com.thetruebetplayleague.teamMember.domain.model.TeamMember;
import com.thetruebetplayleague.teamMember.domain.repository.TeamMembeRepository;

public class CreateTeamMemberUserCase {
    private final TeamMembeRepository teamMembeRepository;

    public CreateTeamMemberUserCase(TeamMembeRepository teamMembeRepository){
        this.teamMembeRepository = teamMembeRepository;
    }

    public void createTeamMember(TeamMemberDTO teamMemberDTO){
        TeamMember teamMember = TeamMemberDTO.toDomainModel(teamMemberDTO);
        System.out.println("Has creado una persona "+ teamMember);
        //teamMembeRepository.save(teamMember);
    }
}
