package com.thetruebetplayleague.technician.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thetruebetplayleague.technician.domain.model.Technician;
import com.thetruebetplayleague.technician.infrastructure.TechnicianRepository;



public class TechnicianMySQLAdapter implements TechnicianRepository{
    private String url;
    private String user;
    private String pass;    

    public TechnicianMySQLAdapter(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public void save(Technician technician){
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            String query = "INSERT INTO technician (teamMemberId, specializationId) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, technician.getTeamMemberId());
                statement.setInt(2, technician.getSpecializationId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Se ha producido un erro :(. Motivo: " + e.getMessage());
        }
    }

    @Override
    public List<Technician> findAll(){
        try (Connection c = DriverManager.getConnection(url, user, pass)){
            List<Technician> technicians = new ArrayList<>();
            String query = "SELECT teamMemberId, medicalRolId FROM technician";
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int TeamMemberId = rs.getInt("teamMemberId");
                    int specializationId = rs.getInt("technicianRolId");
                    technicians.add(new Technician(TeamMemberId, specializationId));
                    
                }
                return technicians;
            } 
        } catch (Exception e) {
            System.out.println("se ha producido un error ;(. Motivo: \n");
        }
        return null;
    }

    @Override
    public List<Technician> findByTeam() {
        try (Connection c = DriverManager.getConnection(url, user, pass)){
            List<Technician> technicians = new ArrayList<>();
            String query = """
                    SELECT tm.name, tm.lastName, tm.countryId, mr.name FROM technician AS m
                    INNER JOIN teamMember AS tm ON m.teamMemberId = tm.id
                    INNER JOIN medicalRol AS mr ON mr.id = 
                    """;
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int TeamMemberId = rs.getInt("teamMemberId");
                    int specializationId = rs.getInt("medicalRolId");
                    technicians.add(new Technician(TeamMemberId, specializationId));
                    
                }
                return technicians;
            } 
        } catch (Exception e) {
            System.out.println("se ha producido un error ;(. Motivo: \n");
        }
        return null;
    }
}
