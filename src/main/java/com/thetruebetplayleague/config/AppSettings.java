package com.thetruebetplayleague.config;

import java.sql.Connection;
import java.sql.SQLException;

import com.thetruebetplayleague.country.adapters.in.CountryConsoleAdapter;
import com.thetruebetplayleague.country.adapters.out.CountryMySQLAdapter;
import com.thetruebetplayleague.country.application.CountryService;
import com.thetruebetplayleague.country.infrastructure.CountryRepository;
import com.thetruebetplayleague.medicalRol.domain.repository.MedicalRolrepository;
import com.thetruebetplayleague.medicalRol.infrastructure.inbound.controller.MedicalRolController;
import com.thetruebetplayleague.medicalRol.infrastructure.outbound.MedicalRolMySQLAdapter;
import com.thetruebetplayleague.team.adapters.in.TeamConsoleAdapter;
import com.thetruebetplayleague.team.adapters.out.TeamAdapterMySQL;
import com.thetruebetplayleague.team.adapters.out.TeamAdapterStatsMySQL;
import com.thetruebetplayleague.team.application.TeamService;
import com.thetruebetplayleague.team.infrastructure.StatsTeamRepository;
import com.thetruebetplayleague.team.infrastructure.TeamRepository;


public class AppSettings {
    String url = "jdbc:mysql://localhost:3306/betplayLeague";
    String user = "campus2023";
    String pass = "campus2023";

    public  static void closeConnection(Connection c){
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println("No se cerró la conexión :(. La ram va a explotar");
            e.getMessage();
        }
    }
        
    

    public   TeamConsoleAdapter startTeamModule(){
        TeamRepository teamRepository = new TeamAdapterMySQL(this.url, this.user, this.pass);
        StatsTeamRepository statsTeamRepository = new TeamAdapterStatsMySQL( this.url, this.user, this.pass);
        TeamService teamService = new TeamService(teamRepository, statsTeamRepository);
        return new TeamConsoleAdapter(teamService);
    }

    public CountryConsoleAdapter startCountryModule(){
        CountryRepository countryRepository = new CountryMySQLAdapter(this.url, this.user, this.pass);
        CountryService countryService = new CountryService(countryRepository);
        return new CountryConsoleAdapter(countryService);
    }

    public MedicalRolController startMedicalRolModule(){
        MedicalRolrepository medicalRolrepository = new MedicalRolMySQLAdapter(this.url, this.user, this.pass);
        return new MedicalRolController(medicalRolrepository); 
    }

    





}
