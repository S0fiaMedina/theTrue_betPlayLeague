package com.thetruebetplayleague.medic;

import java.util.List;

public interface MedicRepository {
    public void save(Medic medic);

    public List<Medic> findAll();

}
