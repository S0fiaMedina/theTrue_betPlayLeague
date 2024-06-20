package com.thetruebetplayleague.medic;

public class Medic {

    private int teamMemberId;
    private int specializationId;
    

    public Medic(int teamMemberId, int specializationId) {
        this.teamMemberId = teamMemberId;
        this.specializationId = specializationId;
    }


    public int getTeamMemberId() {
        return teamMemberId;
    }


    public void setTeamMemberId(int teamMemberId) {
        this.teamMemberId = teamMemberId;
    }


    public int getSpecializationId() {
        return specializationId;
    }


    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }


    

   
}
