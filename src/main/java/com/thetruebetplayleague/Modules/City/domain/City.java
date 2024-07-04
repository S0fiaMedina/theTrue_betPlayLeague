package com.thetruebetplayleague.Modules.City.domain;

public class City {
    private int id;
    private String name;
    private int idCity;


    public City() {
    }




    public City(int id, String name, int idCity) {
        this.id = id;
        this.name = name;
        this.idCity = idCity;
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




    public int getIdCity() {
        return idCity;
    }




    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(this.id);
        sb.append("\tNombre: ").append(this.name);
        return sb.toString();
    }

    
}
