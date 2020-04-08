package com.example.ExtremeSportBackend.dao;

import com.example.ExtremeSportBackend.model.ClientRequest;
import com.example.ExtremeSportBackend.model.Location;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LocationDao {

    int insertLocation(UUID id, Location location);

    default int insertLocation(Location location) {
        UUID id = UUID.randomUUID();
        return insertLocation(id, location);
    }

    List<Location> getAllLocations();

    List<Location> getLocationBySport(String sport);

    List<Location> getLocationsForClient(ClientRequest client) throws CloneNotSupportedException;

    Optional<Location> getLocationById(UUID id);

    int deleteLocationById(UUID id);

    int updateLocationById(UUID id, Location location);
}
