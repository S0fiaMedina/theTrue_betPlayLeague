package com.thetruebetplayleague.medicalRol.infrastructure.outbound;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.thetruebetplayleague.country.domain.model.Country;
import com.thetruebetplayleague.medicalRol.domain.model.MedicalRol;
import com.thetruebetplayleague.medicalRol.domain.repository.MedicalRolrepository;

public class MedicalRolMySQLAdapter implements MedicalRolrepository{
    private String url;
    private String user;
    private String pass;    

    public MedicalRolMySQLAdapter(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public List<MedicalRol> findAll(){
        List<MedicalRol> roles = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(this.url, this.user, this.pass)){
            
            String query = "SELECT id, name FROM medicalRol";
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    MedicalRol medicalRol = new MedicalRol(id, name);
                    roles.add(medicalRol);
                }
                
            } 
        } catch (Exception e) {
            System.out.println("se ha producido un error ;(. Motivo: \n");
        }
        return roles;
    }

    @Override
    public MedicalRol findById(int id){
        MedicalRol medicalRol = null;
        try (Connection c = DriverManager.getConnection(url, user, pass)){
            
            String query = "SELECT id, name FROM medicalRol";
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int idRol = rs.getInt("id");    
                    String name = rs.getString("name");
                    medicalRol = new MedicalRol(idRol, name);
                }
                
            } 
        } catch (Exception e) {
            System.out.println("se ha producido un error ;(. Motivo: \n");
        }
        return medicalRol;
        
    }
}
