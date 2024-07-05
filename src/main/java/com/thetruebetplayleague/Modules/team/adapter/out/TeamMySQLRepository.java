package com.thetruebetplayleague.Modules.team.adapter.out;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.team.domain.Team;
import com.thetruebetplayleague.Modules.team.infrastructure.TeamRepository;
import com.thetruebetplayleague.console.Util;

public class TeamMySQLRepository implements TeamRepository{

    private String url;
    private String user;
    private String password;

    

    public TeamMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public List<Team> findAll() {
        List<Team> teams = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            
            String query = "SELECT * FROM team;";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()){
                    Team team = new Team();

                    team.setId( resultSet.getInt("id"));
                    team.setName( resultSet.getString("name"));
                    team.setPlayedGames( resultSet.getInt("played_games"));
                    team.setWonGames( resultSet.getInt("won_games"));
                    team.setLostGames( resultSet.getInt("lost_games"));
                    team.setTiedGames( resultSet.getInt("tied_games"));
                    team.setScoredGoals( resultSet.getInt("scored_goals"));
                    team.setGoalsConceded(resultSet.getInt("goals_conceded"));
                    team.setTotalOfPoints(resultSet.getInt("total_of_Points"));
                    teams.add(team);
                }
                
                
            }
        } catch (Exception e) {
            System.out.println(">> Se ha producido un error. Motivo: " + e.getMessage());
        }
        return teams;
    }

    @Override
    public Optional<Team> findById(int id) {
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT * FROM team WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                // ejecutar
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();

                // crea pais
                Team team = new Team();
                while (rs.next()){
                    team =new Team();

                    team.setId( rs.getInt("id"));
                    team.setName( rs.getString("name"));
                    team.setPlayedGames( rs.getInt("played_games"));
                    team.setWonGames( rs.getInt("won_games"));
                    team.setLostGames( rs.getInt("lost_games"));
                    team.setTiedGames( rs.getInt("tied_games"));
                    team.setScoredGoals( rs.getInt("scored_goals"));
                    team.setGoalsConceded(rs.getInt("goals_conceded"));
                    team.setTotalOfPoints(rs.getInt("total_of_Points"));

                }
                return Optional.of(team);
            }

        } catch(Exception e){

            System.out.println(">> Ha ocurrido un error\n>> Motivo " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void update(Team team) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE team SET name = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, team.getName());
                statement.setInt(2, team.getId());
                statement.executeUpdate();
                
                Util.showASign("PROCESO EXITOSO", "Actualizacion realizada");
            }
        } catch (Exception e) {
            System.out.println(">> Se ha producido un error. Motivo: " + e.getMessage());
        }
        
    }

    @Override
    public void save(Team team) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO team(name) VALUES (?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, team.getName());
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
            String query = "DELETE FROM team WHERE id = ?";
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
