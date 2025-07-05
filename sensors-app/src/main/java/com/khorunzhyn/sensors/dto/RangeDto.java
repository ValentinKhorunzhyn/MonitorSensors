package com.khorunzhyn.sensors.dto;


import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;

public class RangeDto {

    @Min(value = 0, message = "Value <from> can't be sub zero")
    private int from;


    @Min(value = 0, message = "Value <to> can't be sub zero")
    private int to;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "RangeDto{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }

    @AssertTrue(message = "'from' must be less than 'to'")
    public boolean isFromLessThanTo() {
        return from < to;
    }
}
