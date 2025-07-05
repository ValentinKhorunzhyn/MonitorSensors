package com.khorunzhyn.statistics.model.sensor;

public class SensorUnit {
    private Long id;

    private String unitName; // bar, voltage, °C, %

    public SensorUnit() {
    }

    public SensorUnit(String unitName) {
        this.unitName = unitName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public String toString() {
        return "SensorUnit {" +
                "id=" + id +
                ", unitName='" + unitName + '\'' +
                '}';
    }
}
