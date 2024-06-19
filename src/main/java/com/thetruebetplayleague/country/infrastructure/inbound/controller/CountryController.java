package com.thetruebetplayleague.country.infrastructure.inbound.controller;

import java.util.List;

import com.thetruebetplayleague.country.application.CountryService;
import com.thetruebetplayleague.country.application.dto.CountryDTO;
import com.thetruebetplayleague.country.domain.model.Country;
import com.thetruebetplayleague.country.domain.repository.CountryRepository;
import com.thetruebetplayleague.country.infrastructure.inbound.view.CountryView;

public class CountryController {
    private CountryRepository countryRepository;
    private CountryService countryService;
    private CountryView countryView;
    
    public CountryController(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
        this.countryService = new CountryService(countryRepository);
        this.countryView  = new CountryView();

    }

    public void run(){
        List<Country> countries;
            int op = countryView.runView();
            if (op == 1){
                String name = countryView.getName();
                this.countryService.newCountry(this.makeDTO(name)); // le pasa el dto al servicio

            } else if(op == 2){
                countries = this.countryService.getAllCountries();
                int id = countryView.chooseCountry(countries);
                boolean success = this.countryService.verifyCountry(id);
                // basicamente un do while mientras esto, devuelve falso para manejar validaciones. con el while ddel main, se remueve los whiles de cada controlador
            }
    }

    public CountryDTO makeDTO(String name){
        return new CountryDTO(0, name);
    }
}
