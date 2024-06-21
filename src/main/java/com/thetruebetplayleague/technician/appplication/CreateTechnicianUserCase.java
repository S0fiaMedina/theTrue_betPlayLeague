package com.thetruebetplayleague.technician.appplication;

import com.thetruebetplayleague.technician.domain.model.Technician;
import com.thetruebetplayleague.technician.infrastructure.TechnicianRepository;

public class CreateTechnicianUserCase {
    private final TechnicianRepository technicianRepository;

    public CreateTechnicianUserCase(TechnicianRepository technicianRepository){
        this.technicianRepository = technicianRepository;
    }

    public void newTechnician (Technician technician){
        technicianRepository.save(technician);
    }
}
