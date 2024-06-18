package com.thetruebetplayleague.team.application;

import com.thetruebetplayleague.team.application.dto.TeamDTO;
import com.thetruebetplayleague.team.application.userCases.CreateNewTeamUserCase;
import com.thetruebetplayleague.team.domain.repository.TeamDAO;

public class TeamService {
    private final TeamDAO teamRepository;
    private TeamDTO teamDTO;

    private CreateNewTeamUserCase createNewTeamUserCase;
    
    public TeamService(TeamDAO teamDAO){
        this.teamRepository = teamDAO;
        this.createNewTeamUserCase = new CreateNewTeamUserCase(this.teamRepository);
    }

    public void createNewTeam(TeamDTO teamDTO){
        createNewTeamUserCase.createTeam(teamDTO);
    }

    //getters y setters
    public TeamDAO getTeamRepository() {
        return teamRepository;
    }

    public TeamDTO getTeamDTO() {
        return teamDTO;
    }

    public void setTeamDTO(TeamDTO teamDTO) {
        this.teamDTO = teamDTO;
    }

    public CreateNewTeamUserCase getCreateNewTeamUserCase() {
        return createNewTeamUserCase;
    }


    



}
