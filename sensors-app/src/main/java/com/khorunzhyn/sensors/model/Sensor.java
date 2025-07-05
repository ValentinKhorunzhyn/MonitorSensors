package com.khorunzhyn.sensors.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(schema = "catalogue", name = "table_sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can't be empty")
    @Size(min = 3, max = 30)
    private String name;

    @NotBlank(message = "Model is required")
    @Size(max = 15)
    private String model;

    @Embedded
    private SensorRange range;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SensorType type;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SensorUnit unit;

    @Size(max = 40)
    private String location;

    @Size(max = 200)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public SensorRange getRange() {
        return range;
    }

    public void setRange(SensorRange range) {
        this.range = range;
    }

    public SensorType getType() {
        return type;
    }

    public void setType(SensorType type) {
        this.type = type;
    }

    public SensorUnit getUnit() {
        return unit;
    }

    public void setUnit(SensorUnit unit) {
        this.unit = unit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Sensor {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", range=" + range +
                ", type=" + type +
                ", unit=" + unit +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
