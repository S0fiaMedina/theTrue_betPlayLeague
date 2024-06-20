package com.thetruebetplayleague.teamMember.application;

import java.util.List;

import com.thetruebetplayleague.country.domain.model.Country;
import com.thetruebetplayleague.country.infrastructure.CountryRepository;
import com.thetruebetplayleague.team.domain.model.Team;
import com.thetruebetplayleague.team.infrastructure.TeamRepository;
import com.thetruebetplayleague.teamMember.application.userCases.CreateTeamMemberUserCase;
import com.thetruebetplayleague.teamMember.domain.model.TeamMember;
import com.thetruebetplayleague.teamMember.infrastructure.TeamMemberRepository;

public class TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;
    private final CountryRepository countryRepository;
    private final TeamRepository teamRepository;

    //casos de uso
    private final CreateTeamMemberUserCase createTeamMemberUserCase;

    public TeamMemberService(TeamMemberRepository teamMemberRepository, CountryRepository countryRepository,
     TeamRepository teamRepository){

        this.teamMemberRepository = teamMemberRepository;
        this.countryRepository = countryRepository;
        this.teamRepository = teamRepository;
        this.createTeamMemberUserCase = new CreateTeamMemberUserCase(this.teamMemberRepository);
    }

    public int newTeamMember(TeamMember teamMember){
        return this.createTeamMemberUserCase.createTeamMember(teamMember);
    }

    public List<Country> getAllCountries() {
        return this.countryRepository.findAll();
    }

    public List<Team> getAllTeams(){
        return this.teamRepository.findAll();
    }




    
}
