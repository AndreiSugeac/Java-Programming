package com.example.ExtremeSportBackend.model;

public class ClientResponse {

    private Location location;
    private int estimatedCost;

    public ClientResponse (Location location, int estimatedCost) {
        this.location = location;
        this.estimatedCost = estimatedCost;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(int estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    @Override
    public String toString() {
        return "ClientResponse{" +
                location.toString() +
                ", estimatedCost=" + estimatedCost +
                '}';
    }
}
