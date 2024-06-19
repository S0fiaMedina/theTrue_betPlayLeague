package com.thetruebetplayleague.team.infrastructure.outbound;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.thetruebetplayleague.team.domain.model.Team;
import com.thetruebetplayleague.team.domain.repository.TeamDAO;

public class TeamAdapterMySQL  implements TeamDAO{
    private String url;
    private String user;
    private String pass;



    

    public TeamAdapterMySQL(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public List<Team> findAll() {
        
        try (Connection c = DriverManager.getConnection(url, user, pass)){
            List<Team> teams = new ArrayList<>();
            String query = "SELECT id, name  FROM team";
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    teams.add(new Team(id, query));
                    System.out.println("El equipo es: " + id + " " + name);
                }
                return teams;
            } 
        } catch (Exception e) {
            System.out.println("se ha producido un error ;(. Motivo: \n");
        }
        return null;
    }

    @Override
    public Team findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Team team) {
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            String query = "INSERT INTO team (name) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, team.getName());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}   
