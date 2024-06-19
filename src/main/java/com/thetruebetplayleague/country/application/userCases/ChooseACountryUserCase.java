package com.thetruebetplayleague.country.application.userCases;


import com.thetruebetplayleague.country.domain.model.Country;
import com.thetruebetplayleague.country.domain.repository.CountryRepository;

public class ChooseACountryUserCase {
    
    private CountryRepository countryRepository;

    public ChooseACountryUserCase(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }


    public Country findThecountry(int id){
        return this.countryRepository.findById(id); //retorna lo que hayo mysql
        
    }




}
