package com.thetruebetplayleague.team.infrastructure.inbound.view;

import java.util.List;

import com.thetruebetplayleague.config.Utileria;
import com.thetruebetplayleague.team.domain.model.Team;


public class TeamView {
    String[] options = {"Registrar equipo", 
    "Ver equipo con mas puntos", 
    "Ver equipo con mas goles", 
    "Ver equipo con mas partidos ganados", 
    "Ver la suma de goles de los equipo", 
    "Ver promedio de goles de los equipos", 
    "Salir"};
    
    public TeamView(){

    }

    public int menuTeam(){
        System.out.println("*******************\n MODULO DE EQUIPOS \n *******************");
        System.out.println("Seleccione la opcion de su preferencia");
        Utileria.imprimirOpciones(options);
        return Utileria.validarRango(1, options.length);

    }
    //registro
    public String getName(){
        return Utileria.getStringInput(">> Digite el nombre del equipo: ");
    }

    public void showSumOfGoals(int sum){
        Utileria.mostrarInforme("La suma de goles es: " + sum);
    }

    public void showAvgOfGoals( double avgGoals){
        Utileria.mostrarInforme("El promedio de goles es: " + avgGoals);
    }

    public void showTeamWithMostPoints(Team team){
        Utileria.mostrarInforme("El equipo con mas puntos es: " + team.getName() + " con un total de " + team.getTotalOfPoints() + " puntos.");
    }

    public void showTeamWithMostGoalsScored(Team team){
        Utileria.mostrarInforme("El equipo con mas goles anotados es: " + team.getName() + " con un total de " + team.getScoredGoals() + " puntos.");
    }

    public void showTeamWithMostWonGames(Team team){
        Utileria.mostrarInforme("El equipo con mas partidos ganados es: " + team.getName() + " con un total de " + team.getWonGames() + " puntos.");
    }




    public int chooseTeam(List<Team> teams){
    System.out.println("----- EQUIPOS DISPONIBLES ------");
    teams.forEach(System.out::println);
    return Utileria.getIntInput(">> Escribe el id del equipo que deseas seleccionar");
    }
    




    
}
