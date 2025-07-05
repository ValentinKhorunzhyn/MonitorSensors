package com.khorunzhyn.sensors.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "catalogue", name = "table_sensor_type")
public class SensorType {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
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
