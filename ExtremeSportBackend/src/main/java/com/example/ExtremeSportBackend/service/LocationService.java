package com.example.ExtremeSportBackend.service;

import com.example.ExtremeSportBackend.dao.LocationDao;
import com.example.ExtremeSportBackend.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Location> getLocationBySport(String extremeSport) {
        return locationDao.getLocationBySport(extremeSport);
    }
}
