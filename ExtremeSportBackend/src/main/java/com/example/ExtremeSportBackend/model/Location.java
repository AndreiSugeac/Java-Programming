package com.example.ExtremeSportBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Location extends City{

    UUID locationId;
    private List<ExtremeSports> extremeSport;

    public Location(@JsonProperty("extremeSport")  List<ExtremeSports> extremeSport, @JsonProperty("city") String cityName,
                    @JsonProperty("region") String regionName, @JsonProperty("country") String countryName,
                    @JsonProperty("id") UUID id) {
        super(cityName, regionName, countryName);
        this.extremeSport = extremeSport;
        this.locationId = id;
    }

    public void addSport( String sport, Date period, int cost) {
            this.extremeSport.add(new ExtremeSports(sport, period, cost));
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
}
