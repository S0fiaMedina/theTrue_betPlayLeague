package com.thetruebetplayleague.Modules.Country.application;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.Country.domain.Country;
import com.thetruebetplayleague.Modules.Country.infrastructure.CountryRepository;

public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAllCountries(){
        return this.countryRepository.findAll();
    }

    public Optional<Country>  findCountryById(int id){
        return this.countryRepository.findById(id);
    }

    public void saveCountry(Country country){
        this.countryRepository.save(country);
    }

    public void updateCountry(Country country){
        this.countryRepository.update(country);
    }

    public void deleteCountry(int id){
        this.countryRepository.delete(id);
    }
}
