package com.thetruebetplayleague.medic;

public class CreateNewMedicUserCase {
    private final MedicRepository medicRepository;

    public CreateNewMedicUserCase(MedicRepository medicRepository){
        this.medicRepository = medicRepository;
    }

    public void newMedic(Medic medic){
        medicRepository.save(medic);
    }



}
