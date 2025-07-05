package com.khorunzhyn.sensors.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class SensorDto {

    @NotBlank(message = "Name can't be empty")
    @Size(min = 3, max = 30)
    private String name;

    @NotBlank(message = "Model is required")
    @Size(max = 15)
    private String model;

    @Valid
    private RangeDto range;

    private String type;
    private String unit;

    @Size(max = 40)
    private String location;

    @Size(max = 200)
    private String description;

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

    public RangeDto getRange() {
        return range;
    }

    public void setRange(RangeDto range) {
        this.range = range;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
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
        return "SensorDto{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", range=" + range +
                ", type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
