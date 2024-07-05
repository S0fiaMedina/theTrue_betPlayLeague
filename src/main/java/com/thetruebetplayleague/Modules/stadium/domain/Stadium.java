package com.thetruebetplayleague.Modules.stadium.domain;

public class Stadium {
    private int id;
    private String name;
    private int idCity;
    private int capacity;

    public Stadium() {
    }

    public Stadium(int id, String name, int idCity, int capacity) {
        this.id = id;
        this.name = name;
        this.idCity = idCity;
        this.capacity = capacity;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(this.id);
        sb.append("\tNombre: ").append(this.name);
        sb.append("\tCapacidad : ").append(this.capacity);

        return sb.toString();
    }

    
}
