package com.thetruebetplayleague.team.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.thetruebetplayleague.team.domain.model.Team;
import com.thetruebetplayleague.team.infrastructure.StatsTeamRepository;

public class TeamAdapterStatsMySQL  implements StatsTeamRepository{
    private String url;
    private String user;
    private String pass;



    

    public TeamAdapterStatsMySQL(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }
    
    @Override
    public int getTotalOfGoals(){
        int sumOfGoals = 0;
        try (Connection c = DriverManager.getConnection(url, user, pass)){
            String query = "SELECT SUM(scoredGoals) AS totalGoals FROM team";
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    sumOfGoals = rs.getInt("totalGoals");
                }
            } 
        } catch (Exception e) {
            System.out.println("se ha producido un error ;(. Motivo: \n" + e.getMessage());
        }
        return sumOfGoals;
        
    }

    @Override
    public Team getTeamWithMostPoints(){
        Team teamWithMostPoints = null;
        try (Connection c = DriverManager.getConnection(url, user, pass)){
            String query = "SELECT name, totalOfPoints FROM team ORDER BY totalOfPoints DESC LIMIT 1";
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    teamWithMostPoints = new Team();
                    teamWithMostPoints.setName(rs.getString("name"));
                    teamWithMostPoints.setTotalOfPoints(rs.getInt("totalOfPoints"));
                }
            } 
        } catch (Exception e) {
            System.out.println("se ha producido un error ;(. Motivo: \n" + e.getMessage());
        }
        return teamWithMostPoints;
    }

    @Override
    public Team getTeamWithMostGoalsScored(){
        Team teamWithMostGoalsScored = null;
        try (Connection c = DriverManager.getConnection(url, user, pass)){
            String query = "SELECT name, scoredGoals FROM team ORDER BY scoredGoals DESC LIMIT 1";
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    teamWithMostGoalsScored = new Team();
                    teamWithMostGoalsScored.setName(rs.getString("name"));
                    teamWithMostGoalsScored.setScoredGoals(rs.getInt("scoredGoals"));
                }
            } 
        } catch (Exception e) {
            System.out.println("se ha producido un error ;(. Motivo: \n" + e.getMessage());
        }
        return teamWithMostGoalsScored;

    }

    @Override
    public Team getTeamWithMostWonGames(){
        Team teamWithMostWonGames = null;
        try (Connection c = DriverManager.getConnection(url, user, pass)){
            String query = "SELECT name, wonGames FROM team ORDER BY wonGames DESC LIMIT 1";
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    teamWithMostWonGames = new Team();
                    teamWithMostWonGames.setName(rs.getString("name"));
                    teamWithMostWonGames.setWonGames(rs.getInt("wonGames"));
                }
            } 
        } catch (Exception e) {
            System.out.println("se ha producido un error ;(. Motivo: \n" + e.getMessage());
        }
        return teamWithMostWonGames;

    }

    @Override
    public double getAverageOfGoals(){
        double averageOfGoals = 0;
        try (Connection c = DriverManager.getConnection(url, user, pass)){
            String query = "SELECT AVG(scoredGoals) AS averageOfGoals FROM team";
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    averageOfGoals = rs.getDouble("averageOfGoals");
                }
            } 
        } catch (Exception e) {
            System.out.println("se ha producido un error ;(. Motivo: \n");
        }
        return averageOfGoals;

    }

}
