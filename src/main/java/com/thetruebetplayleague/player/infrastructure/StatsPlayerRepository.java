package com.thetruebetplayleague.player.infrastructure;

import com.thetruebetplayleague.player.domain.model.Player;

public interface StatsPlayerRepository {
    Player findPlayerWithMostYellowCards();
    Player findPlayerWithMostRedCards();
    Player findPlayerWithMostGoalsScored();
}
