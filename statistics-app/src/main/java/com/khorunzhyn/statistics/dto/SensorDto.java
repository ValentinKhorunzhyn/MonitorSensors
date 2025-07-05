package com.khorunzhyn.statistics.dto;

public class SensorDto {
    private String name;
    private String model;
    private RangeDto range;
    private String type;
    private String unit;
    private String location;
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
