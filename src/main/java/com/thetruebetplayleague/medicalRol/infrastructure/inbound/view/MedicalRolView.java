package com.thetruebetplayleague.medicalRol.infrastructure.inbound.view;

import java.util.List;

import com.thetruebetplayleague.config.Utileria;
import com.thetruebetplayleague.medicalRol.domain.model.MedicalRol;

public class MedicalRolView {
    public MedicalRolView(){

    }



    public void showAllMedicalRoles(List<MedicalRol> roles){
        System.out.println("-------------------");
        System.out.println(" ROLES MEDICOS ");
        System.out.println("-------------------");
        roles.forEach(System.out::println);
    }

    public int chooseMedicRol(){
        return Utileria.getIntInput(">> Selecciona un id");
    }

    public void showChosenMedicRol(MedicalRol medicalRol){
        System.out.println("Has escogido " + medicalRol.getName());
    }
}
