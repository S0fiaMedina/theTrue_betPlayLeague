package com.thetruebetplayleague.team.adapters.in;

import com.thetruebetplayleague.config.Utileria;
import com.thetruebetplayleague.team.application.TeamService;
import com.thetruebetplayleague.team.domain.model.Team;

public class TeamConsoleAdapter {
    private final TeamService teamService;
    String[] options = {"Registrar equipo", 
    "Ver equipo con mas puntos", 
    "Ver equipo con mas goles", 
    "Ver equipo con mas partidos ganados", 
    "Ver la suma de goles de los equipo", 
    "Ver promedio de goles de los equipos", 
    "Salir"};

    public TeamConsoleAdapter(TeamService teamService){
        this.teamService = teamService;
    }

    public void runView(){
        System.out.println("*******************\n MODULO DE EQUIPOS \n *******************");
        System.out.println("Seleccione la opcion de su preferencia");
        Utileria.imprimirOpciones(options);
        int choice =  Utileria.validarRango(1, options.length);

        Team teamWithMost = null;

        switch(choice){
            case 1: // registrar equipo
                String teamName = Utileria.getStringInput(">> Digite el nombre del equipo: ");
                this.teamService.createNewTeam(new Team(0, teamName));
                break;

            case 2: // equipo con mas puntos
                teamWithMost = this.teamService.getTeamWithMostPoints();
                Utileria.mostrarInforme("El equipo con mas puntos es: " + teamWithMost.getName() + " con un total de " + teamWithMost.getTotalOfPoints() + " puntos.");
                break;
            case 3: // Equipo con mas goles 
                teamWithMost = this.teamService.getTeamWithMostGoals();
                Utileria.mostrarInforme("El equipo con mas goles anotados es: " + teamWithMost.getName() + " con un total de " + teamWithMost.getScoredGoals() + " goles.");
                break;
            case 4:  // Equipo con mas partidos ganados
                teamWithMost = this.teamService.getTeamWithMostWonGames();
                Utileria.mostrarInforme("El equipo con mas partidos ganados es: " + teamWithMost.getName() + " con un total de " + teamWithMost.getWonGames() + " partidos ganados.");
                break;
            case 5: // suma de goles 
                int sumGoals = this.teamService.getTotalOfGoals();
                Utileria.mostrarInforme("La suma de goles es: " + sumGoals);
                break;
            case 6: // promedio de goles
                double avgGoals = this.teamService.getAverageOfGoals();
                Utileria.mostrarInforme("El promedio de goles es: " + avgGoals);
                break;
            
        }

  
    }
}
