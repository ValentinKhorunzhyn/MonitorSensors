package com.khorunzhyn.sensors.service;

import com.khorunzhyn.sensors.model.SensorUnit;
import com.khorunzhyn.sensors.repository.SensorUnitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SensorUnitService {

    private static final Logger log = LoggerFactory.getLogger(SensorUnitService.class);

    private final SensorUnitRepository sensorUnitRepository;

    public SensorUnitService(SensorUnitRepository sensorUnitRepository) {
        this.sensorUnitRepository = sensorUnitRepository;
    }

    public List<SensorUnit> findAllSensorUnits() {
        log.info("Service started get all sensor units");
        return sensorUnitRepository.findAll();
    }
}
