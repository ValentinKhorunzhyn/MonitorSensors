package com.khorunzhyn.sensors.controller;

import com.khorunzhyn.sensors.dto.SensorDto;
import com.khorunzhyn.sensors.model.Sensor;
import com.khorunzhyn.sensors.service.SensorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/sensors")
@Tag(name = "Sensors", description = "Sensors management")
public class SensorsRestController {

    private static final Logger log = LoggerFactory.getLogger(SensorsRestController.class);

    private final SensorService sensorService;

    public SensorsRestController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Operation(summary = "Get sensor by name and model or get all")
    @GetMapping
    public List<Sensor> findSensors(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) String model) {
        log.info("Get all sensors with included parameters name = {} and model = {}", name, model);
        return sensorService.findAllSensors(name, model);
    }

    @Operation(summary = "Create sensor with request body")
    @PostMapping
    public ResponseEntity<?> createSensor(@Valid @RequestBody SensorDto dto,
                                          BindingResult bindingResult,
                                          UriComponentsBuilder uriComponentsBuilder) throws BindException {
        log.info("Create new sensor with parameters: name = {} and model = {}", dto.getName(), dto.getModel());

        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            Sensor sensor = sensorService.createSensor(dto);
            return ResponseEntity
                    .created(uriComponentsBuilder
                            .replacePath("/api/sensors/{sensorId}")
                            .build(Map.of("sensorId", sensor.getId())))
                    .body(sensor);
        }
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ProblemDetail> handleNoSuchElementException(NoSuchElementException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

}
