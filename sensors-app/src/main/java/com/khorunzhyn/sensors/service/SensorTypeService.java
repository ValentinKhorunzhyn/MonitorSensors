package com.khorunzhyn.sensors.service;

import com.khorunzhyn.sensors.model.SensorType;
import com.khorunzhyn.sensors.repository.SensorTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorTypeService {

    private static final Logger log = LoggerFactory.getLogger(SensorTypeService.class);

    private final SensorTypeRepository sensorTypeRepository;

    public SensorTypeService(SensorTypeRepository sensorTypeRepository) {
        this.sensorTypeRepository = sensorTypeRepository;
    }

    public List<SensorType> findAllSensorTypes() {
        log.info("Service started get all sensor types");
        return sensorTypeRepository.findAll();
    }

}
