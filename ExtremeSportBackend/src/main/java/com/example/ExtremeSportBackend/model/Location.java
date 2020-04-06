package com.example.ExtremeSportBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location extends City{

    private final String extremeSport;

    public Location(@JsonProperty("sport") String extremeSport, @JsonProperty("city") String cityName,
                    @JsonProperty("region") String regionName, @JsonProperty("country") String countryName) {
        super(cityName, regionName, countryName);
        this.extremeSport = extremeSport;
    }

    public String getExtremeSport() {
        return extremeSport;
    }
}
