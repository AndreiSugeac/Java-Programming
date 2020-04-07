package com.example.ExtremeSportBackend.API;

import com.example.ExtremeSportBackend.model.ExtremeSports;
import com.example.ExtremeSportBackend.model.Location;
import com.example.ExtremeSportBackend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

    @GetMapping(path = "{sport}")
    public List<Location> getLocationBySport(@PathVariable("sport") String sport) {
        return locationService.getLocationBySport(sport);
    }

    @GetMapping(path = "{id}")
    public Optional<Location> getLocationById(@PathVariable("id")UUID id) {
        return locationService.getLocationById(id);
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
