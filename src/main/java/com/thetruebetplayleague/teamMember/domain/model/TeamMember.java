package com.thetruebetplayleague.teamMember.domain.model;

public class TeamMember {
    private long id;
    private int TeamId;
    private String name;
    private String lastName;
  

    private String countryId;
    private String rol;

    public TeamMember(){

    }

    public TeamMember(int id, int teamId, String name, String countryId, String rol) {
        this.id = id;
        TeamId = teamId;
        this.name = name;
        this.countryId = countryId;
        this.rol = rol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    

   
    

}
