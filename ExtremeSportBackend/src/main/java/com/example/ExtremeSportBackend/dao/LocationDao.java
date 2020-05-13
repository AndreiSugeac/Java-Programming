package com.example.ExtremeSportBackend.dao;

import com.example.ExtremeSportBackend.model.ClientRequest;
import com.example.ExtremeSportBackend.model.ClientResponse;
import com.example.ExtremeSportBackend.model.Location;
import org.springframework.ui.ModelMap;

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

    List<Location> getLocationByCity(String city);

    List<Location> getLocationByRegion(String region);

    List<Location> getLocationByCountry(String country);

    List<ClientResponse> getLocationsForClient(ClientRequest client);

    Optional<Location> getLocationById(UUID id);

    int deleteLocationById(UUID id);

    int updateLocationById(UUID id, Location location);
}
