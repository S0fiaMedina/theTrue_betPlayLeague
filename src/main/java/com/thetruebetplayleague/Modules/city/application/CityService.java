package com.thetruebetplayleague.Modules.city.application;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.city.domain.City;
import com.thetruebetplayleague.Modules.city.infrastructure.CityRepository;
import com.thetruebetplayleague.Modules.country.domain.Country;
import com.thetruebetplayleague.Modules.country.infrastructure.CountryRepository;



public class CityService {
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public CityService(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    public List<City> findAllCities(){
        return this.cityRepository.findAll();
    }

    public Optional<City>  findCityById(int id){
        return this.cityRepository.findById(id);
    }

    public void saveCity(City country){
        this.cityRepository.save(country);
    }

    public void updateCity(City country){
        this.cityRepository.update(country);
    }

    public void deleteCity(int id){
        this.cityRepository.delete(id);
    }

    public int getCountryId(int idCountry){
        int foundId = -1 ;
        Optional<Country> optionalCountry  = this.countryRepository.findById(idCountry);

        if (optionalCountry.isPresent()){
            Country country = optionalCountry.get();
            foundId = country.getId();
        }

        return foundId;
    }
}
