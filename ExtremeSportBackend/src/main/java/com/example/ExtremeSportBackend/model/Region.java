package com.example.ExtremeSportBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Region extends Country{

    private final String regionName;

    public Region(@JsonProperty("region") String regionName, @JsonProperty("country") String countryName) {
        super(countryName);
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }
}
