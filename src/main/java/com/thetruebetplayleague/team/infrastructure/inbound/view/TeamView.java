package com.thetruebetplayleague.team.infrastructure.inbound.view;

import com.thetruebetplayleague.config.Utileria;

public class TeamView {
    
    public TeamView(){

    }

    public int menuTeam(){
        System.out.println("*******************\n MODULO DE EQUIPOS \n *******************");
        System.out.println("Seleccione la opcion de su preferencia");
        System.out.println("1. Registrar un equipo");
        System.out.println("2. Salir");
        return Utileria.validarRango(1, 2);

    }
    
    public String getName(){
        return Utileria.getStringInput("Digite el nombre del equipo \n>> ");
    }

    
}
