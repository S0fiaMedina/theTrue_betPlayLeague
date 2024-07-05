package com.thetruebetplayleague.console;

import com.thetruebetplayleague.Modules.city.adapter.in.CityConsoleAdapter;
import com.thetruebetplayleague.Modules.city.adapter.out.CityMySQLRepository;
import com.thetruebetplayleague.Modules.city.application.CityService;
import com.thetruebetplayleague.Modules.city.infrastructure.CityRepository;
import com.thetruebetplayleague.Modules.country.adapter.in.CountryConsoleAdapter;
import com.thetruebetplayleague.Modules.country.adapter.out.CountryMySQLRepository;
import com.thetruebetplayleague.Modules.country.application.CountryService;
import com.thetruebetplayleague.Modules.country.infrastructure.CountryRepository;
import com.thetruebetplayleague.Modules.stadium.adapter.in.StadiumConsoleAdapter;
import com.thetruebetplayleague.Modules.stadium.adapter.out.StadiumMySQLRepository;
import com.thetruebetplayleague.Modules.stadium.application.StadiumService;
import com.thetruebetplayleague.Modules.stadium.infrastructure.StadiumRepository;

public class Initializer {
    private String url;
    private String user;
    private String password;

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final StadiumRepository stadiumRepository;

    public Initializer(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
        this.countryRepository = new CountryMySQLRepository(url, user, password);
        this.cityRepository = new CityMySQLRepository(url, user, password);
        this.stadiumRepository = new StadiumMySQLRepository(url, user, password);
    }


    public CountryConsoleAdapter startCountryModule(){
        CountryService countryService = new CountryService(this.countryRepository);
        return new CountryConsoleAdapter(countryService);
    }

    public CityConsoleAdapter startCityModule(){
        CityService cityService = new CityService(this.cityRepository, this.countryRepository);
        return new CityConsoleAdapter(cityService);
    }

    public StadiumConsoleAdapter startStadiumModule(){
        StadiumService stadiumService = new StadiumService(stadiumRepository, cityRepository);
        return new StadiumConsoleAdapter(stadiumService);
    }
}
