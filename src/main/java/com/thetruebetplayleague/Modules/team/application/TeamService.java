package com.thetruebetplayleague.Modules.team.application;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.team.domain.Team;
import com.thetruebetplayleague.Modules.team.infrastructure.TeamRepository;



public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findAllCountries(){
        return this.teamRepository.findAll();
    }

    public Optional<Team>  findTeamById(int id){
        return this.teamRepository.findById(id);
    }

    public void saveTeam(Team Team){
        this.teamRepository.save(Team);
    }

    public void updateTeam(Team Team){
        this.teamRepository.update(Team);
    }

    public void deleteTeam(int id){
        this.teamRepository.delete(id);
    }
}
