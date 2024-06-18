package com.thetruebetplayleague.team.domain.repository;

import com.thetruebetplayleague.team.domain.model.Team;

public interface StatsTeamRepository {
    Team getTeamWithMostGoalsScored();
    
    Team getTeamWithMostPoints();

    Team getTeamWithMostWonGames();

    double getAverageOfGoals();

    int getTotalOfGoals();
}