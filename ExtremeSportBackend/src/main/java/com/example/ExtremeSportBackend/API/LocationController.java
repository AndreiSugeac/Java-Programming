package com.example.ExtremeSportBackend.API;

import com.example.ExtremeSportBackend.model.Location;
import com.example.ExtremeSportBackend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RequestMapping("api/v1/location")
@RestController
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public void addLocation(@RequestBody Location location) {
        locationService.addLocation(location);
    }

    @GetMapping
    public List<Location> getLocations() {
        return locationService.getLocations();
    }

    @GetMapping(path = "{sport}")
    public List<Location> getLocationBySport(@PathVariable("sport") String extremeSport) {
        return locationService.getLocationBySport(extremeSport);
    }
  }
