package com.khorunzhyn.sensors.mapper;

import com.khorunzhyn.sensors.dto.SensorDto;
import com.khorunzhyn.sensors.model.Sensor;
import com.khorunzhyn.sensors.model.SensorRange;
import com.khorunzhyn.sensors.model.SensorType;
import com.khorunzhyn.sensors.model.SensorUnit;

public class SensorObjectMapper {

    public static Sensor mapToEntity(SensorDto dto, SensorType type, SensorUnit unit) {
        Sensor sensor = new Sensor();
        sensor.setName(dto.getName());
        sensor.setModel(dto.getModel());
        sensor.setLocation(dto.getLocation());
        sensor.setDescription(dto.getDescription());

        sensor.setType(type);

        sensor.setRange(new SensorRange(dto.getRange().getFrom(), dto.getRange().getTo()));
        sensor.setUnit(unit);
        return sensor;
    }

    public static void mapToEntity(SensorDto dto, Sensor sensor) {
        sensor.setName(dto.getName());
        sensor.setModel(dto.getModel());
        sensor.getRange().setValueFrom(dto.getRange().getFrom());
        sensor.getRange().setValueTo(dto.getRange().getTo());
        sensor.getType().setTypeName(dto.getType());
        sensor.getUnit().setUnitName(dto.getUnit());
//        sensor.setRange(new SensorRange(, ));
//        sensor.setType(new SensorType(dto.getType()));
//        sensor.setUnit(new SensorUnit(dto.getUnit()));
        sensor.setLocation(dto.getLocation());
        sensor.setDescription(dto.getDescription());
    }

}
