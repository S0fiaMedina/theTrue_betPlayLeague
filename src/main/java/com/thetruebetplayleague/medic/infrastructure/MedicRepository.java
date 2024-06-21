package com.thetruebetplayleague.medic.infrastructure;

import java.util.List;

import com.thetruebetplayleague.medic.domain.model.Medic;

public interface MedicRepository {
    public void save(Medic medic);

    public List<Medic> findAll();

    public List<Medic> findByTeam();

}
