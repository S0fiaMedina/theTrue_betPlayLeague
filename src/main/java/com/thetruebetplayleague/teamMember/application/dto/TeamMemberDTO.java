package com.thetruebetplayleague.teamMember.application.dto;

import com.thetruebetplayleague.teamMember.domain.model.TeamMember;

public class TeamMemberDTO {
    private int id;
    private int teamId;
    private String name;
    private String lastName;
    private int nationality;
    private String rol;

    public TeamMemberDTO(int id, int teamId, String name,  String lastName, int nationality, String rol) {
        this.id = id;
        this.teamId = teamId;
        this.name = name;
        this.lastName = lastName;
        this.nationality = nationality;
        this.rol = rol;
    }

    

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationality) {
        this.nationality = nationality;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getIdTeam() {
        return teamId;
    }



    public void setIdTeam(int teamId) {
        this.teamId = teamId;
    }

    public static TeamMember toDomainModel(TeamMemberDTO teamMemberDTO){
        return new TeamMember(teamMemberDTO.getId(), teamMemberDTO.getIdTeam(), teamMemberDTO.getName(), teamMemberDTO.getLastName(), teamMemberDTO.getNationality(),  teamMemberDTO.getRol());
        
    }




    

    

}
