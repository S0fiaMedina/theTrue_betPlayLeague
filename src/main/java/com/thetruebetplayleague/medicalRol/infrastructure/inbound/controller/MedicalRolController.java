package com.thetruebetplayleague.medicalRol.infrastructure.inbound.controller;

import java.util.List;

import com.thetruebetplayleague.medicalRol.application.MedicalRolService;
import com.thetruebetplayleague.medicalRol.domain.model.MedicalRol;
import com.thetruebetplayleague.medicalRol.domain.repository.MedicalRolrepository;
import com.thetruebetplayleague.medicalRol.infrastructure.inbound.view.MedicalRolView;

public class MedicalRolController {
    private final MedicalRolrepository rolRepository;
    private final MedicalRolService medicalRolService;
    private final MedicalRolView medicalRolView;


    public MedicalRolController(MedicalRolrepository medicalRolrepository){
        this.rolRepository = medicalRolrepository;
        this.medicalRolService = new MedicalRolService(this.rolRepository);
        this.medicalRolView = new MedicalRolView();
    }

    public void run(){
        //List<MedicalRol> medicalRoles = medicalRolService.bringAll();
        //medicalRolView.showAllMedicalRoles(medicalRoles);
        
        int rolOp = medicalRolView.chooseMedicRol();
        MedicalRol medicalRol = medicalRolService.getRol(rolOp);
        medicalRolView.showChosenMedicRol(medicalRol);
    }
}
