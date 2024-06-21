package com.thetruebetplayleague.medic.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thetruebetplayleague.medic.domain.model.Medic;
import com.thetruebetplayleague.medic.infrastructure.MedicRepository;
import com.thetruebetplayleague.team.domain.model.Team;

public class MedicMySQLAdapter implements MedicRepository{
    private String url;
    private String user;
    private String pass;    

    public MedicMySQLAdapter(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public void save(Medic medic){
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            String query = "INSERT INTO Medic (teamMemberId, specializationId) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, medic.getTeamMemberId());
                statement.setInt(2, medic.getSpecializationId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Se ha producido un erro :(. Motivo: " + e.getMessage());
        }
    }

    @Override
    public List<Medic> findAll(){
        try (Connection c = DriverManager.getConnection(url, user, pass)){
            List<Medic> medics = new ArrayList<>();
            String query = "SELECT teamMemberId, medicalRolId FROM medic";
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int TeamMemberId = rs.getInt("teamMemberId");
                    int specializationId = rs.getInt("medicalRolId");
                    medics.add(new Medic(TeamMemberId, specializationId));
                    
                }
                return medics;
            } 
        } catch (Exception e) {
            System.out.println("se ha producido un error ;(. Motivo: \n");
        }
        return null;
    }

    @Override
    public List<Medic> findByTeam() {
        try (Connection c = DriverManager.getConnection(url, user, pass)){
            List<Medic> medics = new ArrayList<>();
            String query = """
                    SELECT tm.name, tm.lastName, tm.countryId, mr.name FROM medic AS m
                    INNER JOIN teamMember AS tm ON m.teamMemberId = tm.id
                    INNER JOIN medicalRol AS mr ON mr.id = 
                    """;
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int TeamMemberId = rs.getInt("teamMemberId");
                    int specializationId = rs.getInt("medicalRolId");
                    medics.add(new Medic(TeamMemberId, specializationId));
                    
                }
                return medics;
            } 
        } catch (Exception e) {
            System.out.println("se ha producido un error ;(. Motivo: \n");
        }
        return null;
    }

}
