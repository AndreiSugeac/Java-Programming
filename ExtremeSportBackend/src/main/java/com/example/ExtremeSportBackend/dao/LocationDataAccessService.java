package com.example.ExtremeSportBackend.dao;

import com.example.ExtremeSportBackend.model.ClientRequest;
import com.example.ExtremeSportBackend.model.ClientResponse;
import com.example.ExtremeSportBackend.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class LocationDataAccessService implements LocationDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LocationDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertLocation(UUID id, Location location) {
        return 0;
    }

    @Override
    public int insertLocation(Location location) {
        return 0;
    }

    @Override
    public List<Location> getAllLocations() {
        final String sql = "SELECT * FROM location";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            return new Location(resultSet.getString("locationname"), resultSet.getString("city"),
                                resultSet.getString("region"), resultSet.getString("country"),
                                UUID.fromString(resultSet.getString("id")));
        });
    }

    @Override
    public List<Location> getLocationBySport(String sport) {
        return null;
    }

    @Override
    public List<Location> getLocationByCity(String city) {
        final String sql = "SELECT * FROM location WHERE city = ?";
        return jdbcTemplate.query(sql, new Object[]{city}, (resultSet, i) -> {
            return new Location(resultSet.getString("locationname"), resultSet.getString("city"),
                    resultSet.getString("region"), resultSet.getString("country"),
                    UUID.fromString(resultSet.getString("id")));
        });
    }

    @Override
    public List<Location> getLocationByRegion(String region) {
        return null;
    }

    @Override
    public List<Location> getLocationByCountry(String country) {
        return null;
    }

    @Override
    public List<ClientResponse> getLocationsForClient(ClientRequest client) {
        return null;
    }

    @Override
    public Optional<Location> getLocationById(UUID id) {
        final String sql = "SELECT * FROM location WHERE id = ?";
        Location location = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            return new Location(resultSet.getString("locationname"), resultSet.getString("city"),
                    resultSet.getString("region"), resultSet.getString("country"),
                    UUID.fromString(resultSet.getString("id")));
        });
        return Optional.ofNullable(location);
    }

    @Override
    public int deleteLocationById(UUID id) {
        return 0;
    }

    @Override
    public int updateLocationById(UUID id, Location location) {
        return 0;
    }
}
