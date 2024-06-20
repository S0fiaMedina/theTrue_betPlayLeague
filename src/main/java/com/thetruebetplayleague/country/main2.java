package com.thetruebetplayleague.country;

import com.thetruebetplayleague.config.AppSettings;
import com.thetruebetplayleague.country.adapters.in.CountryConsoleAdapter;
import com.thetruebetplayleague.country.application.CountryService;

public class main2 {
    public static void main(String[] args) {
        AppSettings appSettings = new AppSettings();
        CountryService countryService = appSettings.startCountryModule();
        CountryConsoleAdapter countryConsoleAdapter =  new CountryConsoleAdapter(countryService);

        countryConsoleAdapter.runView();
        
    }
}
