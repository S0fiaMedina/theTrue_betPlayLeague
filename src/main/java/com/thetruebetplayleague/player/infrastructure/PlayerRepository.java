package com.thetruebetplayleague.player.infrastructure;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.player.domain.model.Player;

public interface PlayerRepository {
    public void save(Player player);

    public List<Player> findAll();

    public Optional<Player> findById(int id);

}
