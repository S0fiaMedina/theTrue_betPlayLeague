package com.thetruebetplayleague.Modules.city.domain;

public class City {
    private int id;
    private String name;
    private int idCountry;


    public City() {
    }




    public City(int id, String name, int idCountry) {
        this.id = id;
        this.name = name;
        this.idCountry = idCountry;
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




    public int getCountryId() {
        return idCountry;
    }




    public void setCountryId(int idCountry) {
        this.idCountry = idCountry;
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(this.id);
        sb.append("\tNombre: ").append(this.name);
        return sb.toString();
    }

    
}
