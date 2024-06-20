package com.thetruebetplayleague.teamMember.adapter.in;

import java.util.List;

import com.thetruebetplayleague.config.Utileria;
import com.thetruebetplayleague.country.domain.model.Country;
import com.thetruebetplayleague.teamMember.application.TeamMemberService;

public class TeamMemberConsoleAdapter {
    private final TeamMemberService teamMemberService;
    String[] roles = {"Tecnico", "Jugador", "Medico"};
    

    public TeamMemberConsoleAdapter(TeamMemberService teamMemberService){
        this.teamMemberService = teamMemberService;
    }

    public void runView(){
        System.out.println("************************************\nMIEMBROS DEL EQUIPO\n************************************");
        System.out.println("1. Agregar una nueva persona al equipo");
        System.out.println("2. salir");
        int op = Utileria.validarRango(1, 2);

        if (op == 1){

        }

    }


    public void getDataOfTeamMember(){
        String name = Utileria.getStringInput(">> Digite el nombre de la persona: ");
        String lastName = Utileria.getStringInput(">> Digite el apellido de la persona: ");
        String rol = this.getRol();

        
        
    }

    public String getRol(){
        Utileria.imprimirOpciones(roles);
        System.out.println("Escoja el rol que tendrá la persona");
        int rolId = Utileria.validarRango(1, roles.length);
        return roles[rolId -1];
    }

    public  int getCountry(){
        // logica para tomar paises
        
    }
}
