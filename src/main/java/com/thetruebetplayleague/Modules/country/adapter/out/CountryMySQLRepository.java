package com.thetruebetplayleague.Modules.country.adapter.out;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.country.domain.Country;
import com.thetruebetplayleague.Modules.country.infrastructure.CountryRepository;
import com.thetruebetplayleague.console.Util;

public class CountryMySQLRepository implements CountryRepository{

    private String url;
    private String user;
    private String password;

    

    public CountryMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            
            String query = "SELECT id, name FROM country;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()){
                    Country country = new Country(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                    );
                    countries.add(country);
                }
                
                
            }
        } catch (Exception e) {
            System.out.println(">> Se ha producido un error. Motivo: " + e.getMessage());
        }
        return countries;
    }

    @Override
    public Optional<Country> findById(int id) {
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, name FROM country WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                // ejecutar
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();

                // crea pais
                Country country = new Country();
                while (rs.next()){
                    country =new Country(
                        rs.getInt("id"), 
                        rs.getString("name")
                    );
                }
                return Optional.of(country);
            }

        } catch(Exception e){

            System.out.println(">> Ha ocurrido un error\n>> Motivo " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void update(Country country) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE country SET name = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, country.getName());
                statement.setInt(2, country.getId());
                statement.executeUpdate();
                
                Util.showASign("PROCESO EXITOSO", "Actualizacion realizada");
            }
        } catch (Exception e) {
            System.out.println(">> Se ha producido un error. Motivo: " + e.getMessage());
        }
        
    }

    @Override
    public void save(Country country) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO country(name) VALUES (?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, country.getName());
                statement.executeUpdate();
                Util.showASign("PROCESO EXITOSO", "El pais se ha registrado correctamente");
            }
        } catch (Exception e) {
            Util.showASign("ERROR", "Ha ocurrido un error con la base de datos");
            System.out.println("motivo: " + e.getMessage());
        }
        
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM country WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);
                statement.executeUpdate();
                Util.showASign("PROCESO EXITOSO", "Informacion eliminada");
            }
        
        } catch (SQLIntegrityConstraintViolationException e){
            Util.showASign("ADVERTENCIA", "No se puede eliminar paises que tengan informacion relacionada. ");
        }
         catch (Exception e) {
            System.out.println("Lo siento, se ha producido un error. Motivo: " + e.getMessage());
        }
    }

    
}
