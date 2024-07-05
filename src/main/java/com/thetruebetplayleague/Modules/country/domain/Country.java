package com.thetruebetplayleague.Modules.country.domain;

public class Country {
    private int id;
    private String name;


    public Country(){

    }

    public Country(int id, String name) {
        this();
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(this.id);
        sb.append("\tNombre: ").append(this.name);
        return sb.toString();
    }

    
}
