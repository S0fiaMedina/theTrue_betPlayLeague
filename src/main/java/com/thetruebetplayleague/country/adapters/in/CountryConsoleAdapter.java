package com.thetruebetplayleague.country.adapters.in;

import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.config.Utileria;
import com.thetruebetplayleague.country.application.CountryService;
import com.thetruebetplayleague.country.domain.model.Country;

public class CountryConsoleAdapter {

    private final CountryService countryService;

    String[] options = {
        "Agregar pais", 
        "Seleccionar pais", 
        "Salir"
    };


    public CountryConsoleAdapter(CountryService countryService){
        this.countryService = countryService;
    }
    
    public void runView(){
        
        System.out.println("----- PAISES ----------");
        Utileria.imprimirOpciones(options);
        int choice =  Utileria.validarRango(1, options.length);

        //agrergar pais
        if (choice == 1){
            String name = Utileria.getStringInput(">> Escribe el nombre del nuevo pais");
            Country newCountry = new Country(0,name);
            countryService.newCountry(newCountry);

        
        } else if (choice == 2){ // mostrar paises
            Optional<Country> countrySelected = null;
            int idSelected = this.chooseCountry();
            countrySelected = countryService.getCountry(idSelected);

            while(countrySelected == null){
                int newId = Utileria.getIntInput("!\tERROR: Has ingresado un id invalido, por favor intentalo de nuevo");
                countrySelected = countryService.getCountry(newId);
            }

            System.out.println("Has seleccionado el pais " + countrySelected.get().getId() + ": " + countrySelected.get().getName());
            
        } 

    }

    public int chooseCountry(){
        List<Country> countries = countryService.getAllCountries();
        System.out.println("----- PAISES DISPONIBLES ------");
        countries.forEach(System.out::println);
        return Utileria.getIntInput(">> Escribe el id del pais que deseas seleccionar");
    }
}
