package com.thetruebetplayleague.medicalRol.domain.model;

public class MedicalRol {
    private int id;
    private String name;

    

    public MedicalRol(int id, String name){
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
    public String toString() {
        return id + " " + name ;
    }

    
}
