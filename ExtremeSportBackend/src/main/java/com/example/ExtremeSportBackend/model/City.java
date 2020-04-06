package com.example.ExtremeSportBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City extends Region {

    private final String cityName;

    public City(@JsonProperty("city") String cityName, @JsonProperty("region") String regionName,
                @JsonProperty("country") String countryName) {
        super(regionName, countryName);
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
}
