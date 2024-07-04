package com.thetruebetplayleague.Modules.City.infrastructure;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.City.domain.City;



public interface CityRepository {

    public Optional<City> findById(int id);

    public List<City> findAll();

    public void update(City city);

    public void save(City city);

    public void delete(int id);
    
}
