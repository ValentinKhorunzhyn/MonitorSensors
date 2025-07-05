package com.khorunzhyn.sensors.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "catalogue", name = "table_sensor_unit")
public class SensorUnit {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
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
