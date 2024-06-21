package com.thetruebetplayleague.medic.adapter.in;

import com.thetruebetplayleague.config.Utileria;

public class MedicConsoleAdapter {
    public MedicConsoleAdapter(){

    }

    public int getMedicalRolId(){
        //getAll de medicalRol
        return Utileria.getIntInput("Digite el id del rol que va a tener el medico");
    }

    
}
