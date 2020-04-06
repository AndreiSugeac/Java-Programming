package com.example.ExtremeSportBackend.dao;

import com.example.ExtremeSportBackend.model.Location;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("fakeDAO")
public class FakeLocationDataAccessService implements LocationDao{

    private static List<Location> DB = new ArrayList<>();

    @Override
    public int insertLocation(Location location) {
        DB.add(new Location(location.getExtremeSport(), location.getCityName(), location.getRegionName(), location.getCountryName()));
        return 1;
    }

    @Override
    public List<Location> getAllLocations() {
        return DB;
    }

    @Override
    public List<Location> getLocationBySport(String extremeSport) {
        return DB.stream().
                filter(loc -> loc.getExtremeSport().equals(extremeSport)).collect(Collectors.toList());
    }


}
