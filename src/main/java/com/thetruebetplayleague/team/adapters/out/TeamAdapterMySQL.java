package com.thetruebetplayleague.team.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.thetruebetplayleague.team.domain.model.Team;
import com.thetruebetplayleague.team.infrastructure.TeamRepository;

public class TeamAdapterMySQL  implements TeamRepository{
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
    public Optional<Team> findById(int id) {
        try (Connection connection = DriverManager.getConnection(this.url, this.user, this.pass)) {
            String query = "SELECT * FROM team WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                            int teamId = resultSet.getInt("id");
                            String name = resultSet.getString("name");
                            System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") ); // test
                            Team team = new Team(teamId, name);
                        
                        return Optional.of(team);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
        
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
