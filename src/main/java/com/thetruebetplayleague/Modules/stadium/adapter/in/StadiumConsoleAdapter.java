package com.thetruebetplayleague.Modules.stadium.adapter.in;


import java.util.List;
import java.util.Optional;

import com.thetruebetplayleague.Modules.stadium.application.StadiumService;
import com.thetruebetplayleague.Modules.stadium.domain.Stadium;
import com.thetruebetplayleague.console.Util;

public class StadiumConsoleAdapter {

    String header = """
            ++++++++++++++++++++++++++
                    ESTADIOS    
            ++++++++++++++++++++++++++
            """;

    private final StadiumService stadiumService;

    String[] options = {
        "1. Crear estadio",
        "2. Actualizar estadio",
        "3. Buscar estadio",
        "4. Eliminar estadios",
        "5. Listar estadios",
        "6. Salir"

    };

    public StadiumConsoleAdapter(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
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
                    this.createStadium();
                    break;
            
                case 2:
                    this.updateStadium();
                    break;

                case 3:
                    this.findStadium();
                    break;
                case 4:
                    this.deleteStadium();
                break;

                case 5:
                    this.listAllStadiums();
                break;
                
                case 6:
                    breaker = false;
                break;
            }
        }
        
    }

    public void createStadium(){
        // pide el nombre del estadio
        String name = Util.getStringInput(">> Digite el nombre del nuevo estadio: ");

        // pide capacidad 
        int newCapacity = Util.getIntInput(">> Digite la capacidad del nuevo estadio: ");  

        // pide id de ciudad
        int foundNewId = -1;
        do{
            int newCityId =Util.getIntInput(">> Ingrese el id de la ciudad al que pertenece el estadio: ");
            foundNewId = this.stadiumService.getCityId(newCityId);
        }while (foundNewId == -1);

        // guardar ciudades
        Stadium stadium = new Stadium();
        stadium.setName(name);
        stadium.setCapacity(newCapacity);
        stadium.setIdCity(foundNewId);

        // guardar
        this.stadiumService.saveStadium(stadium);
    }

    public void findStadium(){
        int searchId = Util.getIntInput(">> Digita el id del estadio  que deseas buscar");
        Optional<Stadium> stadiumFound = this.stadiumService.findStadiumById(searchId);

        stadiumFound.ifPresentOrElse(
            spottedStadium -> {
                System.out.println(">> Informaciónn encontrada: \n" + spottedStadium);
            }, ()-> {
                Util.showASign("AVISO", "Estadio no encontrada");
            });
    }

    public void updateStadium(){
        // pide el id
        int newIdStadium = Util.getIntInput(">> Digite el id del estadio ");
        Optional<Stadium> optionalStadium = this.stadiumService.findStadiumById(newIdStadium);
        
        // validacion
        optionalStadium.ifPresentOrElse(
            spottedStadium -> {
                System.out.println(">> Esta fue la informacion encontrada: \n" + spottedStadium);

                String newName = Util.getStringInput(">> Introduzca el nuevo nombre del estadio : ");
                int newCapacity = Util.getIntInput(">> Digite la capacidad del nuevo estadio: "); 

                spottedStadium.setName(newName);
                spottedStadium.setCapacity(newCapacity);

                this.stadiumService.updateStadium(spottedStadium);

            }, 
                () -> {
                    Util.showASign(" ADVERTENCIA", "Id no encontrado.");
                }
            );
    }

    public void deleteStadium(){
        int deleteId = Util.getIntInput(">> Digita el id del estadio  que deseas buscar");
        Optional<Stadium> stadiumToDelete = this.stadiumService.findStadiumById(deleteId);

        stadiumToDelete.ifPresentOrElse(
            spottedStadium -> {
                this.stadiumService.deleteStadium(deleteId);

            }, ()-> {
                Util.showASign("AVISO", "Esyadio no encontrado");
            });
    }

    public void listAllStadiums(){
        List<Stadium> allStadiums = this.stadiumService.findAllStadiums();
        if (allStadiums.isEmpty()){
            Util.showASign("ERROR", "No hay estadios registrados");
        } else{

            System.out.println(" ------------> ESTADIOS DISPONIBLES <------------ ");
            allStadiums.forEach( foundStadium -> {System.out.println(foundStadium);});
        }
    }
}
