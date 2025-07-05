package com.khorunzhyn.sensors.enums;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum SensorTypes {
    PRESSURE("Pressure"),
    VOLTAGE("Voltage"),
    TEMPERATURE("Temperature"),
    HUMIDITY("Humidity");

    private final String type;

    SensorTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Set<String> names() {
        return Arrays.stream(values())
                .map(SensorTypes::getType)
                .collect(Collectors.toSet());
    }

    public static Set<SensorTypes> all() {
        return EnumSet.allOf(SensorTypes.class);
    }

}
