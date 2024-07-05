package com.thetruebetplayleague.Modules.city.infrastructure;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.city.domain.City;



public interface CityRepository {

    public Optional<City> findById(int id);

    public List<City> findAll();

    public void update(City city);

    public void save(City city);

    public void delete(int id);
    
}
