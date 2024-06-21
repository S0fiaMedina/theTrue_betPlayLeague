package com.thetruebetplayleague.technician.domain.model;

public class Technician {
    private int teamMemberId;
    private int specializationId;
    

    public Technician(int teamMemberId, int specializationId) {
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
