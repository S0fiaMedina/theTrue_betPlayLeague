package com.thetruebetplayleague.teamMember.application.userCases;
import com.thetruebetplayleague.teamMember.domain.model.TeamMember;
import com.thetruebetplayleague.teamMember.infrastructure.TeamMemberRepository;

public class CreateTeamMemberUserCase {
    private final TeamMemberRepository teamMembeRepository;

    public CreateTeamMemberUserCase(TeamMemberRepository teamMembeRepository){
        this.teamMembeRepository = teamMembeRepository;
    }

    public int createTeamMember(TeamMember teamMember){
        return teamMembeRepository.save(teamMember);
    }
}
