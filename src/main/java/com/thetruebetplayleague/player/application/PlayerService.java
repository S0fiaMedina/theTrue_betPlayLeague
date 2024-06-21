package com.thetruebetplayleague.player.application;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.player.domain.model.Player;
import com.thetruebetplayleague.player.infrastructure.PlayerRepository;



public class PlayerService {
    private final PlayerRepository playerRepository;
    private final createNewPlayerUserCase createNewPlayerUserCase;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
        this.createNewPlayerUserCase = new createNewPlayerUserCase(playerRepository);
    }

    public void createNewMedic(Player player){
        this.createNewPlayerUserCase.newPlayer(player);
    }

    public List<Player> bringAllPlayers(){
        return this.playerRepository.findAll();
    }

    public Optional<Player> findById(int id){
        return this.playerRepository.findById(id);
    }
}
