package com.thetruebetplayleague.country.application.dto;

import com.thetruebetplayleague.country.domain.model.Country;

public class CountryDTO {
    private int id;
    private String name;


    public CountryDTO(int id, String name){
        this.name = name;
        this.id = id;
    }

    public static Country toDomainModel(CountryDTO countryDTO){
        return new Country(countryDTO.getId(), countryDTO.getName());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
