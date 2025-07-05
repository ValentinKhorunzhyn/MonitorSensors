package com.khorunzhyn.sensors.service;

import com.khorunzhyn.sensors.dto.SensorDto;
import com.khorunzhyn.sensors.model.Sensor;

import java.util.List;
import java.util.Optional;

public interface ISensorService {

    public List<Sensor> findAllSensors(String name, String model);

    public Optional<Sensor> findSensor(Long id);

    public Sensor createSensor(SensorDto dto);

    public void deleteSensor(Long id);

    public Sensor updateSensor(Long id, SensorDto dto);
}
