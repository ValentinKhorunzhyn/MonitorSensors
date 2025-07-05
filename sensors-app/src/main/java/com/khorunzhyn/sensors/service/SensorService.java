package com.khorunzhyn.sensors.service;

import com.khorunzhyn.sensors.dto.SensorDto;
import com.khorunzhyn.sensors.enums.SensorTypes;
import com.khorunzhyn.sensors.enums.SensorUnits;
import com.khorunzhyn.sensors.mapper.SensorObjectMapper;
import com.khorunzhyn.sensors.model.Sensor;
import com.khorunzhyn.sensors.model.SensorType;
import com.khorunzhyn.sensors.model.SensorUnit;
import com.khorunzhyn.sensors.repository.SensorRepository;
import com.khorunzhyn.sensors.repository.SensorTypeRepository;
import com.khorunzhyn.sensors.repository.SensorUnitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SensorService implements ISensorService {

    private static final Logger log = LoggerFactory.getLogger(SensorService.class);

    private final SensorRepository sensorRepository;
    private final SensorTypeRepository sensorTypeRepository;
    private final SensorUnitRepository sensorUnitRepository;

    public SensorService(SensorRepository sensorRepo, SensorTypeRepository typeRepo, SensorUnitRepository unitRepo) {
        this.sensorRepository = sensorRepo;
        this.sensorTypeRepository = typeRepo;
        this.sensorUnitRepository = unitRepo;
    }

    @Override
    public List<Sensor> findAllSensors(String name, String model) {

        log.info("Service started found sensors with included parameters name = {} and model = {}", name, model);

        if (StringUtils.hasLength(name) || StringUtils.hasLength(model)) {
            return sensorRepository.findByNameContainingIgnoreCaseOrModelContainingIgnoreCase(name, model);
        }

        return sensorRepository.findAll();
    }

    @Override
    public Optional<Sensor> findSensor(Long id) {
        log.info("Service started found sensor with id = {}", id);
        return sensorRepository.findById(id);
    }

    @Override
    @Transactional
    public Sensor createSensor(SensorDto dto) {

        log.info("Service started creating new sensor: name = {} and model = {}", dto.getName(), dto.getModel());
        SensorType type = sensorTypeRepository.findByTypeName(dto.getType()).orElseThrow();
        SensorUnit unit = sensorUnitRepository.findByUnitName(dto.getUnit()).orElseThrow();

        return sensorRepository.save(SensorObjectMapper.mapToEntity(dto, type, unit));
    }

    @Override
    public void deleteSensor(Long id) {
        log.info("Service deleting sensor with Id = {}", id);
        sensorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Sensor updateSensor(Long id, SensorDto dto) {
        if (!SensorTypes.names().contains(dto.getType()) || !SensorUnits.unitNames().contains(dto.getUnit())) {
            throw new NoSuchElementException("SensorType or SensorUnit not present in database");
        }
        log.info("Service starting update sensor with Id = {}", id);
        Sensor existingSensor = sensorRepository.findById(id).orElseThrow();
        SensorObjectMapper.mapToEntity(dto, existingSensor);
        return sensorRepository.save(existingSensor);
    }
}
