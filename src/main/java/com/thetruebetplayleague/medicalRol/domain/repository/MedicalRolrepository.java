package com.thetruebetplayleague.medicalRol.domain.repository;

import java.util.List;

import com.thetruebetplayleague.medicalRol.domain.model.MedicalRol;

public interface MedicalRolrepository {
    public List<MedicalRol> findAll();

    public MedicalRol findById(int id);


}
