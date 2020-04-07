package com.example.ExtremeSportBackend.dao;

import com.example.ExtremeSportBackend.model.ExtremeSports;
import com.example.ExtremeSportBackend.model.Location;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository("fakeDAO")
public class FakeLocationDataAccessService implements LocationDao{

    private static List<Location> DB = new ArrayList<>();

    @Override
    public int insertLocation(UUID id, Location location) {
        DB.add(new Location(location.getExtremeSport(), location.getCityName(), location.getRegionName(), location.getCountryName(),
                id));
        return 1;
    }

    @Override
    public List<Location> getAllLocations() {
        return DB;
    }

    @Override
    public List<Location> getLocationBySport(String sport) {
        return DB.stream().
                filter(loc -> loc.getExtremeSport().stream().anyMatch
                                                    (sp -> sp.getSportName().equals(sport))).
                                                    collect(Collectors.toList());
    }

    @Override
    public Optional<Location> getLocationById(UUID id) {
        return DB.stream().
                filter(loc -> loc.getLocationId().equals(id)).findFirst();
    }

    @Override
    public int deleteLocationById(UUID id) {
        Optional<Location> temp = getLocationById(id);
        DB.remove(temp.get());
        return 1;
    }

    @Override
    public int updateLocationById(UUID id, Location location) {
        return getLocationById(id).map(location1 -> {
            int indexOfLocationToUpdate = DB.indexOf(location1);
            if(indexOfLocationToUpdate >= 0) {
                DB.set(indexOfLocationToUpdate, new Location(location.getExtremeSport(), location.getCityName(),
                        location.getRegionName(), location.getCountryName(), id));
                return 1;
            }
            return 0;
        }).orElse(0);
    }


}
