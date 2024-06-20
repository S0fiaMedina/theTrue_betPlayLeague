package com.thetruebetplayleague.team.infrastructure;



import com.thetruebetplayleague.team.domain.model.Team;

public interface StatsTeamRepository {
    Team getTeamWithMostGoalsScored();
    
    Team  getTeamWithMostPoints();

    Team  getTeamWithMostWonGames();

    double getAverageOfGoals();

    int getTotalOfGoals();
}