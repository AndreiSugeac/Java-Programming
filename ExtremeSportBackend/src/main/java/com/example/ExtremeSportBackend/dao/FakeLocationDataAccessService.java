package com.example.ExtremeSportBackend.dao;

import com.example.ExtremeSportBackend.model.ClientRequest;
import com.example.ExtremeSportBackend.model.ExtremeSports;
import com.example.ExtremeSportBackend.model.Location;
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
    public List<Location> getLocationsForClient(ClientRequest client) throws CloneNotSupportedException {
        List<Location> temp = new ArrayList<>();
        int flag = 1;
        for(Location location: DB) {
            Location loc = location.clone();
            System.out.println("locatia e " + loc.toString());
            flag = 1;
            for(String sp: client.getSports()) {
                System.out.println("Avem sportul: "+ sp);
                int flagSp = 0;
                for(ExtremeSports extremeSports: loc.getExtremeSport()) {
                    System.out.println("Astea sunt sporturile gasite: " + extremeSports.toString());
                    if(extremeSports.getSportName().equals(sp) && client.getStart().after(extremeSports.getStartPeriod()) &&
                       client.getStart().before(extremeSports.getEndPeriod()) && client.getEnd().after(extremeSports.getStartPeriod()) &&
                       client.getEnd().before(extremeSports.getEndPeriod())) {
                        flagSp = 1;
                        long diffInMillies = Math.abs(client.getEnd().getTime() - client.getStart().getTime());
                        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                        System.out.println("Match");
                        extremeSports.setEstimatedCost((int)(diff) * extremeSports.getCostPerDay());
                        break;
                    }
                }
                if(flagSp == 0) {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1) {
                System.out.println("Am gasit o locatie");
                temp.add(loc);
            }
        }

        return temp;

        /*return DB.stream().
                filter(location -> location.getExtremeSport().stream().
                        anyMatch(extremeSports -> extremeSports.getSportName().equals(client.getSports().)))*/
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
