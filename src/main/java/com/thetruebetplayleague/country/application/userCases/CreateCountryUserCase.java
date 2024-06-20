package com.thetruebetplayleague.country.application.userCases;

import com.thetruebetplayleague.country.domain.model.Country;
import com.thetruebetplayleague.country.infrastructure.CountryRepository;

public class CreateCountryUserCase {
    private CountryRepository countryRepository;

    public CreateCountryUserCase(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    public int createNewCountry(Country country){
        return countryRepository.save(country);
    }
}
