package com.thetruebetplayleague.Modules.stadium.infrastructure;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.stadium.domain.Stadium;


public interface StadiumRepository {

    public Optional<Stadium> findById(int id);

    public List<Stadium> findAll();

    public void update(Stadium stadium);

    public void save(Stadium stadium);

    public void delete(int id);
    
}
