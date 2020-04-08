package com.example.ExtremeSportBackend.API;

import com.example.ExtremeSportBackend.model.ClientRequest;
import com.example.ExtremeSportBackend.model.ClientResponse;
import com.example.ExtremeSportBackend.model.Location;
import com.example.ExtremeSportBackend.service.LocationService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/location")
@RestController
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public void addLocation(@Valid @NonNull @RequestBody Location location) {
        locationService.addLocation(location);
    }

    @GetMapping
    public List<Location> getLocations() {
        return locationService.getLocations();
    }

    @GetMapping(path = "Sport/{sport}")
    public List<Location> getLocationBySport(@PathVariable("sport") String sport) {
        return locationService.getLocationBySport(sport);
    }

    @GetMapping(path = "ID/{id}")
    public Optional<Location> getLocationById(@PathVariable("id")UUID id) {
        return locationService.getLocationById(id);
    }

    @GetMapping(path = "City/{city}")
    public List<Location> getLocationByCity(@PathVariable("city") String city) {
        return locationService.getLocationByCity(city);
    }

    @GetMapping(path = "Region/{region}")
    public List<Location> getLocationByRegion(@PathVariable("region") String region) {
        return locationService.getLocationByRegion(region);
    }

    @GetMapping(path = "Country/{country}")
    public List<Location> getLocationByCountry(@PathVariable("country") String country) {
        return locationService.getLocationByCountry(country);
    }

    @GetMapping(path = "Client")
    public List<ClientResponse> getLocationForClient(@Valid @NonNull @RequestBody ClientRequest client) {
        return locationService.getLocationForClient(client);
    }

    @DeleteMapping(path = "{id}")
    public void deleteLocationById(@PathVariable("id")UUID id) {
        locationService.deleteLocationById(id);
    }

    @PutMapping(path = "{id}")
    public void updateLocation(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Location location) {
        locationService.updateLocation(id, location);
    }
  }
