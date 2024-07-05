package com.thetruebetplayleague.Modules.stadium.application;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.city.domain.City;
import com.thetruebetplayleague.Modules.city.infrastructure.CityRepository;
import com.thetruebetplayleague.Modules.stadium.domain.Stadium;
import com.thetruebetplayleague.Modules.stadium.infrastructure.StadiumRepository;





public class StadiumService {
    private final StadiumRepository stadiumRepository;
    private final CityRepository cityRepository;

    public StadiumService(StadiumRepository stadiumRepository, CityRepository cityRepository) {
        this.stadiumRepository = stadiumRepository;
        this.cityRepository = cityRepository;
    }

    public List<Stadium> findAllStadiums(){
        return this.stadiumRepository.findAll();
    }

    public Optional<Stadium>  findStadiumById(int id){
        return this.stadiumRepository.findById(id);
    }

    public void saveStadium(Stadium country){
        this.stadiumRepository.save(country);
    }

    public void updateStadium(Stadium country){
        this.stadiumRepository.update(country);
    }

    public void deleteStadium(int id){
        this.stadiumRepository.delete(id);
    }

    public int getCityId(int idCity){
        int foundId = -1 ;
        Optional<City> optionalCity  = this.cityRepository.findById(idCity);

        if (optionalCity.isPresent()){
            City country = optionalCity.get();
            foundId = country.getId();
        }

        return foundId;
    }
}
