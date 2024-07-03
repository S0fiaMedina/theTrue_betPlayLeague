package com.thetruebetplayleague.console;

import com.thetruebetplayleague.Modules.Country.adapter.in.CountryConsoleAdapter;
import com.thetruebetplayleague.Modules.Country.adapter.out.CountryMySQLRepository;
import com.thetruebetplayleague.Modules.Country.application.CountryService;
import com.thetruebetplayleague.Modules.Country.infrastructure.CountryRepository;

public class Initializer {
    private String url;
    private String user;
    private String password;

    private final CountryRepository countryRepository;

    public Initializer(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
        this.countryRepository = new CountryMySQLRepository(url, user, password);
    }


    public CountryConsoleAdapter startCountryModule(){
        CountryService countryService = new CountryService(this.countryRepository);
        return new CountryConsoleAdapter(countryService);
    }
}
