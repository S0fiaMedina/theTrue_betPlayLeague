package com.thetruebetplayleague.country.application.userCases;


import java.util.Optional;

import com.thetruebetplayleague.country.domain.model.Country;
import com.thetruebetplayleague.country.domain.repository.CountryRepository;

public class ChooseACountryUserCase {
    
    private CountryRepository countryRepository;

    public ChooseACountryUserCase(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }


    public Optional<Country> findThecountry(int id){
        return this.countryRepository.findById(id); //retorna lo que hayo mysql
        
    }




}
