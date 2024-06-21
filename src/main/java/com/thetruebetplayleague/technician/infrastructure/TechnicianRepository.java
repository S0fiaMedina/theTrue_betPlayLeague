package com.thetruebetplayleague.technician.infrastructure;

import java.util.List;

import com.thetruebetplayleague.technician.domain.model.Technician;



public interface TechnicianRepository {
    public void save(Technician technician);

    public List<Technician> findAll();

    public List<Technician> findByTeam();
}
