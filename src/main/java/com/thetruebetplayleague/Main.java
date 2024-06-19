package com.thetruebetplayleague;


import com.thetruebetplayleague.config.AppSettings;
import com.thetruebetplayleague.country.infrastructure.inbound.controller.CountryController;
import com.thetruebetplayleague.team.infrastructure.inbound.controller.TeamController;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║                                        ║");
        System.out.println("║           Liga Betplay Dimayor         ║");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
        //TeamController teamController = new TeamController(AppSettings.starTeamRepository());
        //teamController.run();

        CountryController countryController = new CountryController(null);
        countryController.run();

        
    }
}