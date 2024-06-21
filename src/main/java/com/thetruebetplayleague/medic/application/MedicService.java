package com.thetruebetplayleague.medic.application;

import java.util.List;

import com.thetruebetplayleague.medic.domain.model.Medic;
import com.thetruebetplayleague.medic.infrastructure.MedicRepository;

public class MedicService {
    private final MedicRepository medicRepository;
    private final CreateNewMedicUserCase createNewMedicUserCase;

    public MedicService(MedicRepository medicRepository){
        this.medicRepository = medicRepository;
        this.createNewMedicUserCase = new CreateNewMedicUserCase(medicRepository);
    }

    public void createNewMedic(Medic medic){
        this.createNewMedicUserCase.newMedic(medic);
    }

    public List<Medic> bringAllMedics(){
        return this.medicRepository.findAll();
    }


    
}
