package com.thetruebetplayleague;

import java.sql.Connection;

import com.thetruebetplayleague.config.AppSettings;
import com.thetruebetplayleague.team.infrastructure.inbound.controller.TeamController;

public class Main {
    public static void main(String[] args) {
        
        
        TeamController teamController = new TeamController(AppSettings.starTeamRepository());
       


        
        teamController.run();

        
    }
}