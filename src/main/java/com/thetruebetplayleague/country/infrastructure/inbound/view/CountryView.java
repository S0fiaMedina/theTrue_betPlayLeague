package com.thetruebetplayleague.country.infrastructure.inbound.view;

import java.util.List;

import com.thetruebetplayleague.config.Utileria;
import com.thetruebetplayleague.country.domain.model.Country;

public class CountryView {
    String[] options = {"Agregar pais", "Seleccionar pais", "Salir"};
    
    public int runView(){
        System.out.println("----- PAISES ----------");
        Utileria.imprimirOpciones(options);
        return Utileria.validarRango(1, options.length);
    }

    public int chooseCountry(List<Country> countries){
        System.out.println("----- PAISES DISPONIBLES ------");
        countries.forEach(System.out::println);
        return Utileria.getIntInput(">> Escribe el id del pais que deseas seleccionar");
    }
    public String getName(){
        return Utileria.getStringInput(">> Escribe el nombre del nuevo pais");
    }

    public void printError(){
        System.out.println("!ERROR:\t Id no valido");
    }
}
