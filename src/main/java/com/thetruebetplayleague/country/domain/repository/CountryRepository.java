package com.thetruebetplayleague.country.domain.repository;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.country.domain.model.Country;

public interface CountryRepository {
    public Optional<Country> findById(int id);

    public List<Country> findAll();

    public void save(Country country);
}
