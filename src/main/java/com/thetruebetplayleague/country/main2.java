package com.thetruebetplayleague.country;

import com.thetruebetplayleague.config.AppSettings;
import com.thetruebetplayleague.country.adapters.in.CountryConsoleAdapter;

public class main2 {
    public static void main(String[] args) {
        AppSettings appSettings= new AppSettings();
        CountryConsoleAdapter consoleAdapter= appSettings.startCountryModule();

        consoleAdapter.runView();
    }



}
