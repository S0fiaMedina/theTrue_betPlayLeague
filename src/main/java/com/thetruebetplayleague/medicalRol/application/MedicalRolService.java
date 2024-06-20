package com.thetruebetplayleague.medicalRol.application;

import java.util.List;

import com.thetruebetplayleague.medicalRol.domain.model.MedicalRol;
import com.thetruebetplayleague.medicalRol.domain.repository.MedicalRolrepository;

public class MedicalRolService {
    private final MedicalRolrepository medicalRolrespository;

    public MedicalRolService(MedicalRolrepository medicalRolrespository){
        this.medicalRolrespository = medicalRolrespository;
    }

    public List<MedicalRol> bringAll(){
        return this.medicalRolrespository.findAll();
    }

    public MedicalRol getRol(int id){
        return this.medicalRolrespository.findById(id);
    }
}
