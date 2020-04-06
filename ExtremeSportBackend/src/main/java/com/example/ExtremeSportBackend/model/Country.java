package com.example.ExtremeSportBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {

    private final String countryName;

    public Country(@JsonProperty("country") String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
