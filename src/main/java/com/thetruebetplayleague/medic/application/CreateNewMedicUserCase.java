package com.thetruebetplayleague.medic.application;

import com.thetruebetplayleague.medic.domain.model.Medic;
import com.thetruebetplayleague.medic.infrastructure.MedicRepository;

public class CreateNewMedicUserCase {
    private final MedicRepository medicRepository;

    public CreateNewMedicUserCase(MedicRepository medicRepository){
        this.medicRepository = medicRepository;
    }

    public void newMedic(Medic medic){
        medicRepository.save(medic);
    }



}
