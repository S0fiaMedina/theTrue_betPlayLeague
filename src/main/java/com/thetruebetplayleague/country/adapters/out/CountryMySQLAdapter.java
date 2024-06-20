package com.thetruebetplayleague.country.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.country.domain.model.Country;
import com.thetruebetplayleague.country.infrastructure.CountryRepository;



public class CountryMySQLAdapter implements CountryRepository{
    private String url;
    private String user;
    private String pass;    

    public CountryMySQLAdapter(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(url, user, pass)){
            
            String query = "SELECT id, name FROM country";
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    countries.add(new Country(id, name)); 
                }
                return countries;
            } 
        } catch (Exception e) {
            System.out.println("se ha producido un error ;(. Motivo: \n");
        }
        return null;
        
    }

    @Override
    public Optional<Country> findById(int id) {
         try (Connection connection = DriverManager.getConnection(this.url, this.user, this.pass)) {
            String query = "SELECT * FROM country WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                            int countryId = resultSet.getInt("id");
                            String countrName = resultSet.getString("name");
                            System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") );
                            Country country = new Country(countryId, countrName);
                        
                        return Optional.of(country);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
        
      
    }

    @Override
    public void save(Country country) {
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            String query = "INSERT INTO country (name) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, country.getName());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
