package com.example.ExtremeSportBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class ExtremeSports {
    private String sportName;
    private Date periodOfYear;
    private int costPerDay;

    public ExtremeSports(@JsonProperty("sport") String sportName, @JsonProperty("period") Date periodOfYear,
                         @JsonProperty("cost") int costPerDay) {
        this.sportName = sportName;
        this.periodOfYear = periodOfYear;
        this.costPerDay = costPerDay;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public Date getPeriodOfYear() {
        return periodOfYear;
    }

    public void setPeriodOfYear(Date periodOfYear) {
        this.periodOfYear = periodOfYear;
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
                ", periodOfYear='" + periodOfYear + '\'' +
                ", costPerDay=" + costPerDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtremeSports that = (ExtremeSports) o;
        return costPerDay == that.costPerDay &&
                Objects.equals(sportName, that.sportName) &&
                Objects.equals(periodOfYear, that.periodOfYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportName, periodOfYear, costPerDay);
    }
}
