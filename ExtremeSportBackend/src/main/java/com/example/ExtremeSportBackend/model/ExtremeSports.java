package com.example.ExtremeSportBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
public class ExtremeSports implements Cloneable{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID sportId;

    private String sportName;
    private Date startPeriod;
    private Date endPeriod;
    private int costPerDay;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Location location;

    public ExtremeSports(UUID sportId, String sportName, Date startPeriod, Date endPeriod, int costPerDay) {
        this.sportId = sportId;
        this.sportName = sportName;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.costPerDay = costPerDay;
    }

    public UUID getSportId() {
        return sportId;
    }

    public void setSportId(UUID sportId) {
        this.sportId = sportId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public Date getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Date startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Date getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Date endPeriod) {
        this.endPeriod = endPeriod;
    }

    public int getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
    }

    @Override
    public String toString() {
        return "ExtremeSports{" +
                "sportName='" + sportName + '\'' +
                ", startPeriod=" + startPeriod +
                ", endPeriod=" + endPeriod +
                ", costPerDay=" + costPerDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtremeSports that = (ExtremeSports) o;
        return costPerDay == that.costPerDay &&
                sportName.equals(that.sportName) &&
                startPeriod.equals(that.startPeriod) &&
                endPeriod.equals(that.endPeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportName, startPeriod, endPeriod, costPerDay);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
