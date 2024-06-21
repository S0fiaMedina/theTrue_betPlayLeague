package com.thetruebetplayleague.player.adapter.in;

import com.thetruebetplayleague.config.Utileria;
import com.thetruebetplayleague.player.application.PlayerService;

public class PlayerConsoleAdapter {
    private final PlayerService playerService;
    String[] options = {"Agregar nuevo jugador", "Salir"};
        
    public PlayerConsoleAdapter(PlayerService playerService){
        this.playerService = playerService;
    }

    public void runView(){
        System.out.println("----------------------------\nJUGADORES\n----------------------------");
        Utileria.imprimirOpciones(options);
        int op = Utileria.validarRango(1, options.length);
        if (op == 1){

        }
    }

    public Player(){
        int squadNumber = Utileria.getIntInput(">> Introduzca el dorsal del jugador: ");
        // TODO: logica para elegir posicion

    }
}
