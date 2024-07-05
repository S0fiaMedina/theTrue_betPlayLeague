package com.thetruebetplayleague.Modules.country.adapter.in;


import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.country.application.CountryService;
import com.thetruebetplayleague.Modules.country.domain.Country;
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
        "4. Eliminar paises",
        "5. Listar paises",
        "6. Salir "
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
        boolean breaker = true;

        while (breaker) {
            int op = this.getChoiseFromUser();

            switch (op) {
                case 1:
                    this.createCountry();
                    break;

                case 2:
                    this.updateCountry();
                    break;

                case 3:
                    this.findCountry();
                    break;
                case 4:
                    this.deleteCountry();
                break;

                case 5:
                    this.listAllCountries();
                break;

                case 6:
                    breaker = false;
                break;
            }
        }
        
    }


    public void createCountry(){
        // pide el nombre del ppais
        String name = Util.getStringInput(">> Digite el nombre del nuevo pais: ");

        // guardar paises
        Country country = new Country();
        country.setName(name);

        // guardar
        this.countryService.saveCountry(country);
    }

    public void updateCountry(){
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
    }

    public void findCountry(){
        int searchId = Util.getIntInput(">> Digita el id del pais que deseas buscar");
        Optional<Country> countryFound = this.countryService.findCountryById(searchId);

        countryFound.ifPresentOrElse(
            spottedCountry -> {
                System.out.println(">> Informaciónn encontrada: \n" + spottedCountry);
            }, ()-> {
                Util.showASign("AVISO", "Pais no encontrado");
            }
        );
    }

    public void deleteCountry(){
        int deleteId = Util.getIntInput(">> Digita el id del pais que deseas buscar");
        Optional<Country> countryToDelete = this.countryService.findCountryById(deleteId);

        countryToDelete.ifPresentOrElse(
            spottedCountry -> {
                this.countryService.deleteCountry(deleteId);

            }, ()-> {
                Util.showASign("AVISO", "Pais no encontrado");
            }
        );
    }

    public void listAllCountries(){
        List<Country> allCountries = this.countryService.findAllCountries();
        if (allCountries.isEmpty()){
            Util.showASign("ERROR", "No hay paises registrados");
        } else{
            System.out.println(" ------------> PAISES DISPONIBLES <------------ ");
            allCountries.forEach( foundCountry -> {System.out.println(foundCountry);});
        } 
    }
}
