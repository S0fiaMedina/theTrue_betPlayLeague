package com.thetruebetplayleague.player.application;

import com.thetruebetplayleague.player.domain.model.Player;
import com.thetruebetplayleague.player.infrastructure.PlayerRepository;

public class createNewPlayerUserCase {
    private final PlayerRepository playerRepository;

    public createNewPlayerUserCase(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public void newPlayer(Player player){
        playerRepository.save(player);
    }
}
