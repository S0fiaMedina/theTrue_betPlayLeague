package com.thetruebetplayleague.player.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.player.domain.model.Player;
import com.thetruebetplayleague.player.infrastructure.PlayerRepository;



public class PlayerMySQLAdapter implements PlayerRepository{
    private String url;
    private String user;
    private String pass;


    public PlayerMySQLAdapter(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

   
}
