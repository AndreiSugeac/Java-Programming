package com.example.ExtremeSportBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Location extends City implements Cloneable{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID locationId;

    private String name;

    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "location", orphanRemoval = true)
    private List<ExtremeSports> extremeSport = new ArrayList<>();*/

    public Location(@JsonProperty("locationName") String name, @JsonProperty("city") String cityName,
                    @JsonProperty("region") String regionName, @JsonProperty("country") String countryName,
                    @JsonProperty("id") UUID id) {
        super(cityName, regionName, countryName);
        this.name = name;
        this.locationId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public List<ExtremeSports> getExtremeSport() {
        return extremeSport;
    }

    public void setExtremeSport(List<ExtremeSports> extremeSport) {
        this.extremeSport = extremeSport;
    }*/

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

    @Override
    public String toString() {
        return "Location{\n" +
                ", name='" + name + '\'' +
                "locationId=" + locationId +
                '}';
    }
}
