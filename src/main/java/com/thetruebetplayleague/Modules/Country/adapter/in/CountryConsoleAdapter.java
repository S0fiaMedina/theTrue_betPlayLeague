package com.thetruebetplayleague.Modules.Country.adapter.in;


import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.Country.application.CountryService;
import com.thetruebetplayleague.Modules.Country.domain.Country;
import com.thetruebetplayleague.console.Util;

public class CountryConsoleAdapter {

    String header = """
            ++++++++++++++++++++++++++
                    PAISES
            ++++++++++++++++++++++++++
            """;
    private CountryService countryService;
    String[] options = {
        "1. Crear pais",
        "2. Actualizar pais",
        "3. Buscar pais",
        "4. Eliminar paises"
    };

    public CountryConsoleAdapter(CountryService countryService) {
        this.countryService = countryService;
    }


    public int getChoiseFromUser(){
        System.out.println(header);
        Util.printOptions(options);
        return Util.rangeValidator(1, options.length);
    }


    public void run(){
        int op = this.getChoiseFromUser();

        switch (op) {
            case 1:
                // pide el nombre del ppais
                String name = Util.getStringInput(">> Digite el nombre del nuevo pais: ");
                List<Country> countries = this.countryService.findAllCountries();

                // guardar paises
                Country country = new Country();
                country.setName(name);

                // guardar
                this.countryService.saveCountry(country);
                break;
        
            case 2:
                // pide el id
                
                int newIdCountry = Util.getIntInput(">> Digite el id del pais");
                Optional<Country> optionalCountry = this.countryService.findCountryById(newIdCountry);
                
                // validacion
                optionalCountry.ifPresentOrElse(
                    spottedCountry -> {
                        System.out.println(">> Esta fue la informacion encontrada: \n" + spottedCountry);

                        String newName = Util.getStringInput(">> Introduzca ell nuevo nombre del pais: ");

                        spottedCountry.setName(newName);
                        this.countryService.updateCountry(spottedCountry);

                    }, 
                        () -> {
                            Util.showASign(" ADVERTENCIA", "Id no encontrado.");
                        }
                    );
                
                break;

            case 3:
                int searchId = Util.getIntInput(">> Digita el id del pais que deseas buscar");
                Optional<Country> countryFound = this.countryService.findCountryById(searchId);

                countryFound.ifPresentOrElse(
                    spottedCountry -> {
                        System.out.println(">> Informaciónn encontrada: \n" + spottedCountry);
                    }, ()-> {
                        Util.showASign("AVISO", "Pais no encontrado");
                    });
                break;
            case 4:
                int deleteId = Util.getIntInput(">> Digita el id del pais que deseas buscar");
                Optional<Country> countryToDelete = this.countryService.findCountryById(deleteId);

                countryToDelete.ifPresentOrElse(
                    spottedCountry -> {
                        this.countryService.deleteCountry(deleteId);

                    }, ()-> {
                        Util.showASign("AVISO", "Pais no encontrado");
                    });
            break;
        }
    }
}