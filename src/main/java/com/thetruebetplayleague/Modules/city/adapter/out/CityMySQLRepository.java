package com.thetruebetplayleague.Modules.city.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.city.domain.City;
import com.thetruebetplayleague.Modules.city.infrastructure.CityRepository;
import com.thetruebetplayleague.console.Util;

public class CityMySQLRepository implements CityRepository{

    private String url;
    private String user;
    private String password;

    

    public CityMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            
            String query = "SELECT id, name, country_id FROM city;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()){
                    City city = new City(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("country_id")
                    );
                    cities.add(city);
                }
                
                
            }
        } catch (Exception e) {
            System.out.println(">> Se ha producido un error: " +  e.getMessage());
        }
        return cities;
    }

    @Override
    public Optional<City> findById(int id) {
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, name, country_id FROM city WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                // ejecutar
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();

                // crea pais
                City city = new City();
                while (rs.next()){
                    city =new City(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("country_id")
                    );
                }
                return Optional.of(city);
            }

        } catch(Exception e){

            System.out.println(">> Ha ocurrido un error\n>> Motivo " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void update(City city) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE city SET name = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, city.getName());
                statement.setInt(2, city.getId());
                statement.executeUpdate();
                
                Util.showASign("PROCESO EXITOSO", "Actualizacion realizada");
            }
        } catch (Exception e) {
            System.out.println(">> Ha ocurrido un error\n>> Motivo " + e.getMessage());
        }
        
    }

    @Override
    public void save(City city) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO city(name, country_id) VALUES (?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, city.getName());
                statement.setInt(2, city.getCountryId());
                
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
            String query = "DELETE FROM city WHERE id = ?";
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
