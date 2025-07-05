package com.khorunzhyn.statistics.model.sensor;

public class SensorRange {
    private Integer valueFrom;

    private Integer valueTo;

    public SensorRange() {
    }

    public SensorRange(Integer valueFrom, Integer valueTo) {
        this.valueFrom = valueFrom;
        this.valueTo = valueTo;
    }

    public Integer getValueFrom() {
        return valueFrom;
    }

    public void setValueFrom(Integer valueFrom) {
        this.valueFrom = valueFrom;
    }

    public Integer getValueTo() {
        return valueTo;
    }

    public void setValueTo(Integer valueTo) {
        this.valueTo = valueTo;
    }

    @Override
    public String toString() {
        return "SensorRange {" +
                "valueFrom=" + valueFrom +
                ", valueTo=" + valueTo +
                '}';
    }
}
