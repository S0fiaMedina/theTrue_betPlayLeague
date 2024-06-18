package com.thetruebetplayleague.team.infrastructure.outbound;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thetruebetplayleague.config.AppSettings;
import com.thetruebetplayleague.team.domain.model.Team;
import com.thetruebetplayleague.team.domain.repository.TeamDAO;

public class TeamAdapterMySQL  implements TeamDAO{


    String url = "jdbc:mysql://localhost:3306/betplayLeague";
    String user = "campus2023";
    String pass = "campus2023";

    

    public TeamAdapterMySQL() {
    }

    public TeamAdapterMySQL(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public List<Team> findAll() {

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
