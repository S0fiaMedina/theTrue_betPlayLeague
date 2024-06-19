package com.thetruebetplayleague.team.infrastructure.outbound;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.thetruebetplayleague.team.domain.model.Team;
import com.thetruebetplayleague.team.domain.repository.StatsTeamRepository;

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
            String query = "SELECT name, totalOfPoints FROM team ORDER BY totalOfPoints DESC";
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
        return null;

    }

    @Override
    public Team getTeamWithMostWonGames(){
        return null;

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
