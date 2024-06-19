package com.thetruebetplayleague.country.application.userCases;

import java.util.List;

import com.thetruebetplayleague.country.domain.model.Country;
import com.thetruebetplayleague.country.domain.repository.CountryRepository;

public class GetAllAvaibleCountries {
    private CountryRepository countryRepository;

    public GetAllAvaibleCountries(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    public List<Country> getTheCountries(){
        return this.countryRepository.findAll();
    }

    
}
