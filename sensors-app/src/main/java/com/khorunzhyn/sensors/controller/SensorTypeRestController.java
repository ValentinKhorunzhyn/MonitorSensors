package com.khorunzhyn.sensors.controller;

import com.khorunzhyn.sensors.model.SensorType;
import com.khorunzhyn.sensors.service.SensorTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/types")
@Tag(name = "Sensor types", description = "Sensor types management")
public class SensorTypeRestController {
    private static final Logger log = LoggerFactory.getLogger(SensorTypeRestController.class);
    private final SensorTypeService sensorTypeService;

    public SensorTypeRestController(SensorTypeService sensorTypeService) {
        this.sensorTypeService = sensorTypeService;
    }

    @Operation(summary = "Get all sensors types")
    @GetMapping
    public List<SensorType> findSensorTypes() {
        log.info("Get all sensors types");
        return sensorTypeService.findAllSensorTypes();
    }
}
