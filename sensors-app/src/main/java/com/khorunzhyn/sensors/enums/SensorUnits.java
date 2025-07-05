package com.khorunzhyn.sensors.enums;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum SensorUnits {

    BAR("bar"),
    VOLTAGE("voltage"),
    CELSIUS("°C"),
    PERCENT("%");

    private final String unitName;

    SensorUnits(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitName() {
        return unitName;
    }

    public static Set<String> unitNames() {
        return Arrays.stream(values())
                .map(SensorUnits::getUnitName)
                .collect(Collectors.toSet());
    }

    public static Set<SensorUnits> allUnits() {
        return EnumSet.allOf(SensorUnits.class);
    }

}
