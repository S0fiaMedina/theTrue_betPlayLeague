package com.thetruebetplayleague.player.domain.model;

public class Player {

    private int teamMemberId; // heredado de teamId
    private int squadNumber; // dorsal
    private int scoredGoals;
    private int yellowCards;
    private int redCards;
    private int positionId;




    public Player(){

    }

    

   


    public Player(int teamMemberId, int squadNumber, int scoredGoals, int yellowCards, int redCards, int positionId) {
        this.teamMemberId = teamMemberId;
        this.squadNumber = squadNumber;
        this.scoredGoals = scoredGoals;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.positionId = positionId;
    }






    public int getSquadNumber() {
        return squadNumber;
    }


    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }


    public int getScoredGoals() {
        return scoredGoals;
    }


    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }


    public int getYellowCards() {
        return yellowCards;
    }


    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }


    public int getRedCards() {
        return redCards;
    }


    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }
}
