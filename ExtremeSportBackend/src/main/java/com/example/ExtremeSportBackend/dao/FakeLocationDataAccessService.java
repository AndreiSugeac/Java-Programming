package com.example.ExtremeSportBackend.dao;

import com.example.ExtremeSportBackend.model.*;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Repository("fakeDAO")
public class FakeLocationDataAccessService implements LocationDao{

    private static List<Location> DB = new ArrayList<>();

    @Override
    public int insertLocation(UUID id, Location location) {
        DB.add(new Location(location.getName(), location.getExtremeSport(), location.getCityName(), location.getRegionName(), location.getCountryName(),
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
    public List<Location> getLocationByCity(String city) {
        return DB.stream().
                filter(location -> location.getCityName().equals(city)).collect(Collectors.toList());
    }

    @Override
    public List<Location> getLocationByRegion(String region) {
        return DB.stream().
                filter(location -> location.getRegionName().equals(region)).collect(Collectors.toList());
    }

    @Override
    public List<Location> getLocationByCountry(String country) {
        return DB.stream().
                filter(location -> location.getCountryName().equals(country)).collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> getLocationsForClient(ClientRequest client) {
        List<ClientResponse> temp = new ArrayList<>();
        int flag = 1;
        for(Location loc: DB) {
            int estCost = 0;
            flag = 1;
            for(String sp: client.getSports()) {
                int flagSp = 0;
                for(ExtremeSports extremeSports: loc.getExtremeSport()) {
                    if(extremeSports.getSportName().equals(sp) && client.getStart().after(extremeSports.getStartPeriod()) &&
                       client.getStart().before(extremeSports.getEndPeriod()) && client.getEnd().after(extremeSports.getStartPeriod()) &&
                       client.getEnd().before(extremeSports.getEndPeriod())) {
                        flagSp = 1;
                        long diffInMillies = Math.abs(client.getEnd().getTime() - client.getStart().getTime());
                        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                        estCost += (int)(diff) * extremeSports.getCostPerDay();
                        break;
                    }
                }
                if(flagSp == 0) {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1) {
                ClientResponse temporary = new ClientResponse(loc, estCost);
                temp.add(temporary);
            }
        }
        temp.sort(new ClientResponseComparator());
        return temp;
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
                DB.set(indexOfLocationToUpdate, new Location(location.getName(), location.getExtremeSport(), location.getCityName(),
                        location.getRegionName(), location.getCountryName(), id));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
