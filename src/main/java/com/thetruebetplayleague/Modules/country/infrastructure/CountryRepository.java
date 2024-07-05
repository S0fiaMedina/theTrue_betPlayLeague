package com.thetruebetplayleague.Modules.country.infrastructure;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.country.domain.Country;

public interface CountryRepository {

    public Optional<Country> findById(int id);

    public List<Country> findAll();

    public void update(Country country);

    public void save(Country country);

    public void delete(int id);
    
}
