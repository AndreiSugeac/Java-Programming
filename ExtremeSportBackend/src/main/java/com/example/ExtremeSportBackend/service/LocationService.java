package com.example.ExtremeSportBackend.service;

import com.example.ExtremeSportBackend.dao.LocationDao;
import com.example.ExtremeSportBackend.model.ClientRequest;
import com.example.ExtremeSportBackend.model.ClientResponse;
import com.example.ExtremeSportBackend.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocationService {
    private final LocationDao locationDao;

    @Autowired
    public LocationService(@Qualifier("fakeDAO") LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    public int addLocation(Location location) {
        return locationDao.insertLocation(location);
    }

    public List<Location> getLocations() {
        return locationDao.getAllLocations();
    }

    public List<Location> getLocationBySport(String sport) {
        return locationDao.getLocationBySport(sport);
    }

    public List<Location> getLocationByCity(String city) {
        return locationDao.getLocationByCity(city);
    }

    public List<Location> getLocationByRegion(String region) {
        return locationDao.getLocationByRegion(region);
    }

    public List<Location> getLocationByCountry(String country) {
        return locationDao.getLocationByCountry(country);
    }

    public List<ClientResponse> getLocationForClient(ClientRequest client) {
        return locationDao.getLocationsForClient(client);
    }

    public Optional<Location> getLocationById(UUID id) {
        return locationDao.getLocationById(id);
    }

    public int deleteLocationById(UUID id) {
        return locationDao.deleteLocationById(id);
    }

    public int updateLocation(UUID id, Location location) {
        return locationDao.updateLocationById(id, location);
    }
}
