package com.thetruebetplayleague.teamMember.adapter.out;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.thetruebetplayleague.teamMember.domain.model.TeamMember;
import com.thetruebetplayleague.teamMember.infrastructure.TeamMemberRepository;

public class TeamMemberAdapterMySQL implements TeamMemberRepository{

    private final String url;
    private final String user;
    private final String password;

    public TeamMemberAdapterMySQL(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }



    @Override
    public int save(TeamMember teamMember) {
         try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO teamMember (name, lastName, teamId, , countryId, rol) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, teamMember.getName());
                statement.setString(2, teamMember.getLastName());
                statement.executeUpdate();  

                // Obtener el id generado
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id =  generatedKeys.getInt(1); // Devuelve el ID generado
                    return id;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
