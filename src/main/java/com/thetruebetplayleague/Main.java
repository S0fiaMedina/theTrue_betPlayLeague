package com.thetruebetplayleague;

import java.sql.Connection;
import java.util.Optional;

import com.thetruebetplayleague.config.AppSettings;
import com.thetruebetplayleague.team.infrastructure.inbound.controller.TeamController;

public class Main {
    public static void main(String[] args) {
        
        AppSettings appSettings  = new AppSettings();
        Connection c = appSettings.runMysqlConnection();


        TeamController teamController = new TeamController(null);
        teamController.run();

        appSettings.closeConnection(c);
    }
}