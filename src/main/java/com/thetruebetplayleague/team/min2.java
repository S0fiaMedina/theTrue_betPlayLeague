package com.thetruebetplayleague.team;

import com.thetruebetplayleague.config.AppSettings;
import com.thetruebetplayleague.team.adapters.in.TeamConsoleAdapter;
import com.thetruebetplayleague.team.application.TeamService;

public class min2 {
    public static void main(String[] args) {
     AppSettings appSettings = new AppSettings();

     
     TeamConsoleAdapter teamConsoleAdapter =  appSettings.startTeamModule();

     teamConsoleAdapter.runView();


    }
}
