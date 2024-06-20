package com.thetruebetplayleague.country.infrastructure;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.country.domain.model.Country;

public interface CountryRepository {
    public Optional<Country> findById(int id);

    public List<Country> findAll();

    public int save(Country country);
}
