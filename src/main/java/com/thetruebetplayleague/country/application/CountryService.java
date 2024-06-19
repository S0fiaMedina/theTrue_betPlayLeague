package com.thetruebetplayleague.country.application;

import java.util.List;

import com.thetruebetplayleague.country.application.dto.CountryDTO;
import com.thetruebetplayleague.country.application.userCases.ChooseACountryUserCase;
import com.thetruebetplayleague.country.application.userCases.CreateCountryUserCase;
import com.thetruebetplayleague.country.application.userCases.GetAllAvaibleCountries;
import com.thetruebetplayleague.country.domain.model.Country;
import com.thetruebetplayleague.country.domain.repository.CountryRepository;

public class CountryService {

    private CountryRepository countryRepository;
    private CreateCountryUserCase createCountryUserCase;
    private ChooseACountryUserCase chooseACountryUserCase;
    private GetAllAvaibleCountries getAllAvaibleCountries; 
   

    public CountryService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
        this.createCountryUserCase = new CreateCountryUserCase(this.countryRepository);
        this.chooseACountryUserCase = new ChooseACountryUserCase(this.countryRepository);
        this.getAllAvaibleCountries = new GetAllAvaibleCountries(this.countryRepository);
       
    }

    public void newCountry(CountryDTO countryDTO){
        createCountryUserCase.createNewCountry(countryDTO);
    }

    public List<Country> getAllCountries(){
        return getAllAvaibleCountries.getTheCountries();
    }

    public boolean verifyCountry(int id){
        return chooseACountryUserCase.findThecountry(id) != null;
    }

    


}
