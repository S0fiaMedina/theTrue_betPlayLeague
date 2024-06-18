package com.thetruebetplayleague.teamMember.infrastructure.inbound.view;

import com.thetruebetplayleague.config.Utileria;

public class TeamMemberView {
     String[] roles = {"Tecnico", "Jugador", "Medico"};
    
    public TeamMemberView(){
    }

    public void printHeader(){
        System.out.println("------------------------------");
        System.out.println(" PERSONAS DEL EQUIPO");
        System.out.println("------------------------------");
    }

    public int  teamMemberMenu(){
        this.printHeader();
        System.out.println("1. Agregar una nueva persona al equipo");
        System.out.println("2. salir");
        return Utileria.validarRango(1, 2);
    }

    public String getName(){
        return Utileria.getStringInput(">> Digite el nombre de la persona: ");
    }

    public int getTeamId(){ // que probablemente reciba la consulta de equipos para iterar
        return Utileria.getIntInput(">> Digite el id del equipo: ");
    }

    public String  getNationality(){ // que probablemente reciba la consulta de paises para iterar
        return Utileria.getStringInput(">> Digite la nacionalidad: ");
    }
        
    


    public TeamMemberDTO makeDTO(String name, String nationality, int teamId, int rol){
        String TeamRol = roles[rol - 1]; // obtiene el nombre del rol
        return new TeamMemberDTO(name, nationality, TeamRol);

    }

}
