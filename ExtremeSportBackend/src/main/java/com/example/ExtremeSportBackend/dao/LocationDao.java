package com.example.ExtremeSportBackend.dao;

import com.example.ExtremeSportBackend.model.Location;

import java.util.List;

public interface LocationDao {

    int insertLocation(Location location);

    List<Location> getAllLocations();

    List<Location> getLocationBySport(String extremeSport);
}
