package com.thetruebetplayleague.team.application.dto;

import com.thetruebetplayleague.team.domain.model.Team;

public class TeamDTO {
    int id;
    String name;

    // para registro
    public TeamDTO(String name){
        this.name = name;
    }
    // para edicion
    public TeamDTO(int id, String name){
        this.id = id;
        this.name = name;
    }

    public static  Team toDomainModel(TeamDTO teamDTO){
        return new Team(teamDTO.getId(), teamDTO.getName());
    }

    //getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}
