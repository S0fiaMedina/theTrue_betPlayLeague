package com.thetruebetplayleague.teamMember.domain.model;

public class TeamMember {
    private int id;
    private int TeamId;
    private String name;
    private String lastName;
    private int countryId;
    private String rol;

    public TeamMember(){

    }

    

    public TeamMember(int id, int teamId, String name, String lastName, int countryId, String rol) {
        this.id = id;
        TeamId = teamId;
        this.name = name;
        this.lastName = lastName;
        this.countryId = countryId;
        this.rol = rol;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamId() {
        return TeamId;
    }

    public void setTeamId(int teamId) {
        TeamId = teamId;
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

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }



    @Override
    public String toString() {
        return "TeamMember [id=" + id + ", TeamId=" + TeamId + ", name=" + name + ", lastName=" + lastName
                + ", countryId=" + countryId + ", rol=" + rol + "]";
    }
    
    
   
    

}
