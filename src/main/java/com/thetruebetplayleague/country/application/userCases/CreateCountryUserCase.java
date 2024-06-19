package com.thetruebetplayleague.country.application.userCases;

import com.thetruebetplayleague.country.application.dto.CountryDTO;
import com.thetruebetplayleague.country.domain.model.Country;
import com.thetruebetplayleague.country.domain.repository.CountryRepository;

public class CreateCountryUserCase {
    private CountryRepository countryRepository;

    public CreateCountryUserCase(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    public void createNewCountry(CountryDTO countryDTO){
        Country country = CountryDTO.toDomainModel(countryDTO);
        System.out.println("Has creado un pais cuyo nombre es: " + country.getName());
        countryRepository.save(country);
    }
}
