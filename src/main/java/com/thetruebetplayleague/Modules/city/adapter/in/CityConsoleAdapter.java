package com.thetruebetplayleague.Modules.city.adapter.in;


import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.city.application.CityService;
import com.thetruebetplayleague.Modules.city.domain.City;
import com.thetruebetplayleague.console.Util;

public class CityConsoleAdapter {

    String header = """
            ++++++++++++++++++++++++++
                    CIUDADES    
            ++++++++++++++++++++++++++
            """;

    private final CityService cityService;

    String[] options = {
        "1. Crear ciudad",
        "2. Actualizar ciudad",
        "3. Buscar ciudad",
        "4. Eliminar ciudades",
        "5. Listar ciudades",
        "6. Salir"

    };

    public CityConsoleAdapter(CityService cityService) {
        this.cityService = cityService;
    }


    public int getChoiseFromUser(){
        System.out.println(header);
        Util.printOptions(options);
        return Util.rangeValidator(1, options.length);
    }


    public void run(){
        boolean breaker = true;
        while (breaker){

            int op = this.getChoiseFromUser();

            switch (op) {
                case 1:
                    this.createCity();
                    break;
            
                case 2:
                    this.updateCity();
                    break;

                case 3:
                    this.findCity();
                    break;
                case 4:
                    this.deleteCity();
                break;

                case 5:
                    this.listAllCities();
                break;
                
                case 6:
                    breaker = false;
                break;
            }
        }
        
    }

    public void createCity(){
        // pide el nombre del p
        String name = Util.getStringInput(">> Digite el nombre de la nueva ciudad: ");

            
        // pide id de pais
        int foundNewId = -1;
        do{
            int newCountryId =Util.getIntInput(">> Ingrese el id del pais al que pertenece: ");
            foundNewId = this.cityService.getCountryId(newCountryId);
        }while (foundNewId == -1);

        // guardar ciudades
        City city = new City();
        city.setName(name);
        city.setCountryId(foundNewId);

        // guardar
        this.cityService.saveCity(city);
    }

    public void findCity(){
        int searchId = Util.getIntInput(">> Digita el id de la ciudad  que deseas buscar");
        Optional<City> cityFound = this.cityService.findCityById(searchId);

        cityFound.ifPresentOrElse(
            spottedCity -> {
                System.out.println(">> Informaciónn encontrada: \n" + spottedCity);
            }, ()-> {
                Util.showASign("AVISO", "Ciudad no encontrada");
            });
    }

    public void updateCity(){
        // pide el id
        int newIdCity = Util.getIntInput(">> Digite el id de la ciudad ");
        Optional<City> optionalCity = this.cityService.findCityById(newIdCity);
        
        // validacion
        optionalCity.ifPresentOrElse(
            spottedCity -> {
                System.out.println(">> Esta fue la informacion encontrada: \n" + spottedCity);

                String newName = Util.getStringInput(">> Introduzca ell nuevo nombre de la  ciudad : ");

                spottedCity.setName(newName);
                this.cityService.updateCity(spottedCity);

            }, 
                () -> {
                    Util.showASign(" ADVERTENCIA", "Id no encontrado.");
                }
            );
    }

    public void deleteCity(){
        int deleteId = Util.getIntInput(">> Digita el id de la ciudad  que deseas buscar");
        Optional<City> cityToDelete = this.cityService.findCityById(deleteId);

        cityToDelete.ifPresentOrElse(
            spottedCity -> {
                this.cityService.deleteCity(deleteId);

            }, ()-> {
                Util.showASign("AVISO", "Ciudad no encontrado");
            });
    }

    public void listAllCities(){
        List<City> allCities = this.cityService.findAllCities();
        if (allCities.isEmpty()){
            Util.showASign("ERROR", "No hay es registrados");
        } else{

            System.out.println(" ------------> CIUDADES DISPONIBLES <------------ ");
            allCities.forEach( foundCity -> {System.out.println(foundCity);});
        }
    }
}
