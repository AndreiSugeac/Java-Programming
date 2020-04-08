package com.example.ExtremeSportBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.String;

public class ClientRequest {
    private String[] sports;
    private Date start;
    private Date end;

    public ClientRequest(@Valid @NonNull @JsonProperty("sports") String[] sports, @JsonProperty("startDate") Date start,
                         @JsonProperty("endDate") Date end) throws ParseException {
        this.sports = sports;
        this.start = start;
        this.end = end;
    }

    public String[] getSports() {
        return sports;
    }

    public void setSports(String[] sports) {
        this.sports = sports;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "sports=" + Arrays.toString(sports) +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
