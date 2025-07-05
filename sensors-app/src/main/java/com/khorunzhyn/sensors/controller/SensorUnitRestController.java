package com.khorunzhyn.sensors.controller;

import com.khorunzhyn.sensors.service.SensorUnitService;
import com.khorunzhyn.sensors.model.SensorUnit;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/units")
@Tag(name = "Sensor unit", description = "Sensor units management")
public class SensorUnitRestController {

    private static final Logger log = LoggerFactory.getLogger(SensorUnitRestController.class);
    private final SensorUnitService sensorUnitService;

    public SensorUnitRestController(SensorUnitService sensorUnitService) {
        this.sensorUnitService = sensorUnitService;
    }
    @Operation(summary = "Get all sensors types")
    @GetMapping
    public List<SensorUnit> findSensorUnits() {
        log.info("Get all sensors types");
        return sensorUnitService.findAllSensorUnits();
    }
}
