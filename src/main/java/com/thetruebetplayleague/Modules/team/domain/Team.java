package com.thetruebetplayleague.Modules.team.domain;

public class Team {
    private int id;
    private String name;
    private int playedGames;
    private  int wonGames;
    private int lostGames;
    private int tiedGames;
    private int scoredGoals;
    private int goalsConceded;
    private int totalOfPoints ;


    public Team() {
        this.playedGames = 0;
        this.wonGames = 0;
        this.lostGames = 0;
        this.tiedGames = 0;
        this.scoredGoals = 0;
        this.goalsConceded = 0;
        this.totalOfPoints = 0;
    }


    public Team(int id, String name, int playedGames, int wonGames, int lostGames, int tiedGames, int scoredGoals,
        int goalsConceded, int totalOfPoints) {
        this.id = id;
        this.name = name;
        this.playedGames = playedGames;
        this.wonGames = wonGames;
        this.lostGames = lostGames;
        this.tiedGames = tiedGames;
        this.scoredGoals = scoredGoals;
        this.goalsConceded = goalsConceded;
        this.totalOfPoints = totalOfPoints;
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






    public int getTotalOfPoints() {
        return totalOfPoints;
    }






    public void setTotalOfPoints(int totalOfPoints) {
        this.totalOfPoints = totalOfPoints;
    }






    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(this.id);
        sb.append("\nNombre: ").append(this.name);
        sb.append("\npartidos jugados: ").append(this.playedGames);
        sb.append("\npartidos ganados: ").append(this.wonGames);
        sb.append("\npartidos perdidos: ").append(this.lostGames);
        sb.append("\npartidos empatados: ").append(this.tiedGames);
        sb.append("\ngoles anotados: ").append(this.scoredGoals);
        sb.append("\ngoles en contra: ").append(this.goalsConceded);
        sb.append("\ntotal puntos: ").append(this.totalOfPoints);
        return sb.toString();
    }

    
}
