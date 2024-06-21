package com.thetruebetplayleague.technician.appplication;

import java.util.List;

import com.thetruebetplayleague.technician.domain.model.Technician;
import com.thetruebetplayleague.technician.infrastructure.TechnicianRepository;



public class TechnicianService {
    private final TechnicianRepository technicianRepository;
    private final CreateTechnicianUserCase createTechnicianUserCase;

    public TechnicianService(TechnicianRepository technicianRepository){
        this.technicianRepository = technicianRepository;
        this.createTechnicianUserCase = new CreateTechnicianUserCase(technicianRepository);
    }

    public void createNewTechnician(Technician technician){
        this.createTechnicianUserCase.newTechnician(technician);
    }

    public List<Technician> bringAllTechnicians(){
        return this.technicianRepository.findAll();
    }
}
