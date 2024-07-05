package com.thetruebetplayleague.Modules.stadium.adapter.out;

import java.beans.Statement;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.thetruebetplayleague.Modules.stadium.domain.Stadium;
import com.thetruebetplayleague.Modules.stadium.infrastructure.StadiumRepository;
import com.thetruebetplayleague.console.Util;

public class StadiumMySQLRepository implements StadiumRepository{

    private String url;
    private String user;
    private String password;

    

    public StadiumMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public List<Stadium> findAll() {
        List<Stadium> Stadiums = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            
            String query = "SELECT id, name, id_city, capacity FROM stadium;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()){
                    Stadium stadium = new Stadium(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("id_city"),
                        resultSet.getInt("capacity")
                    );
                    Stadiums.add(stadium);
                }
                
                
            }
        } catch (Exception e) {
            System.out.println(">> Se ha producido un error: " +  e.getMessage());
        }
        return Stadiums;
    }

    @Override
    public Optional<Stadium> findById(int id) {
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, name, id_city, capacity FROM stadium WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                // ejecutar
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();

                // crea pais
                Stadium stadium = new Stadium();
                while (rs.next()){
                    stadium = new Stadium(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("id_city"),
                        rs.getInt("capacity")
                    );
                }
                return Optional.of(stadium);
            }

        } catch(Exception e){

            System.out.println(">> Ha ocurrido un error\n>> Motivo " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void update(Stadium stadium) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE stadium SET name = ?, capacity = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, stadium.getName());
                statement.setInt(2, stadium.getCapacity());
                statement.setInt(3, stadium.getId());
                statement.executeUpdate();
                
                Util.showASign("PROCESO EXITOSO", "Actualizacion realizada");
            }
        } catch (Exception e) {
            System.out.println(">> Ha ocurrido un error\n>> Motivo " + e.getMessage());
        }
        
    }

    @Override
    public void save(Stadium stadium) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO stadium(name, id_city, capacity) VALUES (?, ?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, stadium.getName());
                statement.setInt(2, stadium.getIdCity());
                statement.setInt(3, stadium.getCapacity());
    
                statement.executeUpdate();
                Util.showASign("PROCESO EXITOSO", "La ciudad se ha registrado correctamente");
            }
        } catch (Exception e) {
            Util.showASign("ERROR", "Ha ocurrido un error con la base de datos");
            System.out.println("motivo: " + e.getMessage());
        }
        
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM stadium WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);
                statement.executeUpdate();
                Util.showASign("PROCESO EXITOSO", "Informacion eliminada");
            }
        } catch (SQLIntegrityConstraintViolationException e){
            Util.showASign("ADVERTENCIA", "No se puede eliminar una ciudad que tenga informacion asociada");
        } catch (Exception e) {
            System.out.println("Lo siento, se ha producido un error. Motivo: " + e.getMessage());
        }
        
    }
    
}
