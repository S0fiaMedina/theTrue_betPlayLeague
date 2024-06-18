package com.thetruebetplayleague.teamMember.application.dto;

public class teamMemberDTO {
    private int id;
    private String name;
    private String lastName;
    private String nationality;
    private String rol;

    public teamMemberDTO(int id, String name, String lastName, String nationality, String rol) {
        this.id = id;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    

    

}
