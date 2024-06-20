package com.thetruebetplayleague.medic;

import com.thetruebetplayleague.config.Utileria;

public class MedicView {
    public MedicView(){

    }

    public int getMedicalRolId(){
        //getAll de medicalRol
        return Utileria.getIntInput("Digite el id del rol que va a tener el medico");
    }

    
}
