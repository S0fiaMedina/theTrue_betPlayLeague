package com.thetruebetplayleague.team.domain.model;

public class Team {
    private int id;
    private String name;
    private int playedGames;
    private int wonGames;
    private int lostGames;
    private int tiedGames;
    private int scoredGoals;
    private int goalsConceded;

    // Constructor vacío (por defecto)
    public Team() {
        this.playedGames = 0;
        this.wonGames = 0;
        this.lostGames = 0;
        this.tiedGames = 0;
        this.scoredGoals = 0;
        this.goalsConceded = 0;
    }

    // Constructor con todos los atributos
    public Team(int id, String name) {
        this();
        this.id = id;
        this.name = name;
        
    }

    // Getters y Setters
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

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public int getWonGames() {
        return wonGames;
    }

    public void setWonGames(int wonGames) {
        this.wonGames = wonGames;
    }

    public int getLostGames() {
        return lostGames;
    }

    public void setLostGames(int lostGames) {
        this.lostGames = lostGames;
    }

    public int getTiedGames() {
        return tiedGames;
    }

    public void setTiedGames(int tiedGames) {
        this.tiedGames = tiedGames;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    // Método toString para representar el objeto como cadena de texto
    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playedGames=" + playedGames +
                ", wonGames=" + wonGames +
                ", lostGames=" + lostGames +
                ", tiedGames=" + tiedGames +
                ", scoredGoals=" + scoredGoals +
                ", goalsConceded=" + goalsConceded +
                '}';
    }
}


