package com.khorunzhyn.statistics.model.sensor;

public class SensorType {
    private Long id;

    private String typeName; // Can be: Pressure, Voltage, Temperature, Humidity

    public SensorType() {
    }

    public SensorType(String typeName) {
        this.typeName = typeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "SensorType {" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
