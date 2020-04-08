package com.example.ExtremeSportBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class ExtremeSports implements Cloneable{
    private String sportName;
    private Date startPeriod;
    private Date endPeriod;
    private int costPerDay;

    public ExtremeSports(@JsonProperty("sport") String sportName, @JsonProperty("start") Date startPeriod,
                         @JsonProperty("end") Date endPeriod, @JsonProperty("cost") int costPerDay) {
        this.sportName = sportName;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.costPerDay = costPerDay;
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
