package com.thetruebetplayleague.country.application;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.country.application.userCases.CreateCountryUserCase;
import com.thetruebetplayleague.country.domain.model.Country;
import com.thetruebetplayleague.country.infrastructure.CountryRepository;

public class CountryService {

    private CountryRepository countryRepository;
    private CreateCountryUserCase createCountryUserCase;
   

    public CountryService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
        this.createCountryUserCase = new CreateCountryUserCase(this.countryRepository);
       
    }

    public void newCountry(Country country){
        createCountryUserCase.createNewCountry(country);
    }

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public Optional<Country> getCountry(int id){
        return countryRepository.findById(id);
    }

    


}
