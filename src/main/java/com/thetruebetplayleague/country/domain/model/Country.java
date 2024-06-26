package com.thetruebetplayleague.country.domain.model;

public class Country {
    private int id;
    private String name;

    public Country(){}

    public Country(int id, String name){
        this.name = name;
        this.id = id;
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
    public String toString(){
        return this.getId() + " " + this.getName();
    }

    
}
