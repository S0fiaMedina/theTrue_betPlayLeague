package com.thetruebetplayleague.medic;

import java.util.List;

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
