package com.thetruebetplayleague.country.domain.repository;

import java.util.List;

import com.thetruebetplayleague.country.domain.model.Country;

public interface CountryRepository {
    public Country findById(int id);

    public List<Country> findAll();

    public void save(Country country);
}
