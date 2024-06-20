package com.thetruebetplayleague;


import com.thetruebetplayleague.config.AppSettings;
import com.thetruebetplayleague.config.Utileria;
import com.thetruebetplayleague.country.adapters.in.controller.CountryController;
import com.thetruebetplayleague.medicalRol.infrastructure.inbound.controller.MedicalRolController;
import com.thetruebetplayleague.team.adapters.in.controller.TeamController;

public class Main {
    public static void main(String[] args) {
        // inicializar controladores
        AppSettings appSettings = new AppSettings();
        TeamController teamController = appSettings.startTeamModule();
        MedicalRolController medicalRolController = appSettings.startMedicalRolModule();

        String[] options = {"Equipos", "Integrantes de equipo", "Tabla de posiciones", "Salir"};
        boolean flag = true;

        while (flag) {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║                                        ║");
            System.out.println("║           Liga Betplay Dimayor         ║");
            System.out.println("║                                        ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("Bienvenido a la iga betPlay, seleccione la opcion de su preferencia. ");
            Utileria.imprimirOpciones(options);
            int op = Utileria.validarRango(1, options.length);

            switch (op) {
                case 1: // Equipos
                    teamController.run();
                    break;
                case 2: // integrantes de equipo
                    medicalRolController.run();
                    break;
                default: // salida
                    flag = false;
                    break;
            }
        }
    }
}