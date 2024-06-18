package com.thetruebetplayleague.config;

import java.sql.Connection;
import java.sql.SQLException;

import com.thetruebetplayleague.team.domain.repository.TeamDAO;
import com.thetruebetplayleague.team.infrastructure.outbound.TeamAdapterMySQL;

public class AppSettings {

    public  static void closeConnection(Connection c){
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println("No se cerró la conexión :(. La ram va a explotar");
            e.getMessage();
        }
    }
        
    

    public  static TeamDAO starTeamRepository(){
        return new TeamAdapterMySQL();
    }





}
