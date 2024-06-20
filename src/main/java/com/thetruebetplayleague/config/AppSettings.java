package com.thetruebetplayleague.config;

import java.sql.Connection;
import java.sql.SQLException;


import com.thetruebetplayleague.country.adapters.out.CountryMySQLAdapter;
import com.thetruebetplayleague.country.application.CountryService;
import com.thetruebetplayleague.country.infrastructure.CountryRepository;
import com.thetruebetplayleague.medicalRol.domain.repository.MedicalRolrepository;
import com.thetruebetplayleague.medicalRol.infrastructure.inbound.controller.MedicalRolController;
import com.thetruebetplayleague.medicalRol.infrastructure.outbound.MedicalRolMySQLAdapter;
import com.thetruebetplayleague.team.domain.repository.StatsTeamRepository;
import com.thetruebetplayleague.team.domain.repository.TeamDAO;
import com.thetruebetplayleague.team.infrastructure.inbound.controller.TeamController;
import com.thetruebetplayleague.team.infrastructure.outbound.TeamAdapterMySQL;
import com.thetruebetplayleague.team.infrastructure.outbound.TeamAdapterStatsMySQL;

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
        
    

    public   TeamController startTeamModule(){
        TeamDAO teamDAO = new TeamAdapterMySQL(this.url, this.user, this.pass);
        StatsTeamRepository statsTeamRepository = new TeamAdapterStatsMySQL( this.url, this.user, this.pass);
        return new TeamController(teamDAO, statsTeamRepository);
    }

    public CountryService startCountryModule(){
        CountryRepository countryRepository = new CountryMySQLAdapter(this.url, this.user, this.pass);
        return new CountryService(countryRepository);
    }

    public MedicalRolController startMedicalRolModule(){
        MedicalRolrepository medicalRolrepository = new MedicalRolMySQLAdapter(this.url, this.user, this.pass);
        return new MedicalRolController(medicalRolrepository); 
    }

    





}
