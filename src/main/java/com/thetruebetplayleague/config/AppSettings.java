package com.thetruebetplayleague.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.thetruebetplayleague.team.domain.repository.TeamDAO;
import com.thetruebetplayleague.team.infrastructure.outbound.TeamAdapterMySQL;

public class AppSettings {
    
    String url = "jdbc:mysql://localhost:3306/betplayLeague";
    String user = "root";
    String pass = "R00T_12345";

    
    public Connection runMysqlConnection() {
        Connection c = null;
        try {
            if (c == null || c.isClosed()) {
                c = DriverManager.getConnection(url, user, pass);
            }
        } catch (SQLException e) {
            System.out.println("Error establishing connection: " + e.getMessage());
        }
    
        return c;
    }
        
    

    public void startRepositories(){
        TeamDAO teamDAO = new TeamAdapterMySQL();
    }

    public  void closeConnection(Connection c){
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println("No se cerró la conexión :(. La ram va a explotar");
            e.getMessage();
        }
    }
}
