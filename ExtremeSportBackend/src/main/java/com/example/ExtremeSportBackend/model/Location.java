package com.example.ExtremeSportBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Location extends City implements Cloneable{

    private String name;
    UUID locationId;
    private List<ExtremeSports> extremeSport;

    public Location(@JsonProperty("locationName") String name, @JsonProperty("extremeSport")  List<ExtremeSports> extremeSport, @JsonProperty("city") String cityName,
                    @JsonProperty("region") String regionName, @JsonProperty("country") String countryName,
                    @JsonProperty("id") UUID id) {
        super(cityName, regionName, countryName);
        this.name = name;
        this.extremeSport = extremeSport;
        this.locationId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExtremeSports> getExtremeSport() {
        return extremeSport;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }

    @Override
    public Location clone() throws CloneNotSupportedException {
        Location location =  (Location) super.clone();
        return location;
    }
}
