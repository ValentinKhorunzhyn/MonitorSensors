package com.khorunzhyn.sensors.controller;

import com.khorunzhyn.sensors.dto.SensorDto;
import com.khorunzhyn.sensors.model.Sensor;
import com.khorunzhyn.sensors.service.SensorService;
import com.khorunzhyn.sensors.util.StringUtil;
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

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/sensors")
@Tag(name = "Sensor", description = "Sensor management")
public class SensorRestController {

    private static final Logger log = LoggerFactory.getLogger(SensorRestController.class);

    private final SensorService sensorService;

    public SensorRestController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @ModelAttribute("sensor")
    public Sensor getSensor(@PathVariable Long id) {
        log.info("Get sensor with id = {}", id);
        return sensorService.findSensor(id).orElseThrow(() -> new NoSuchElementException(StringUtil.MSG_SENSOR_NOT_FOUND));
    }

    @Operation(summary = "Get sensor by ID")
    @GetMapping("/{id}")
    public Sensor findSensor(@ModelAttribute("sensor") Sensor sensor) {
        return sensor;
    }

    @Operation(summary = "Update sensor with body and ID")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSensor(@PathVariable Long id,
                                          @Valid @RequestBody SensorDto dto,
                                          BindingResult bindingResult) throws BindException {
        log.info("Update sensor with Id = {}", id);
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            sensorService.updateSensor(id, dto);
            return ResponseEntity
                    .noContent()
                    .build();
        }
    }

    @Operation(summary = "Delete sensor by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id) {
        log.info("Delete sensor with Id = {}", id);
        sensorService.deleteSensor(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ProblemDetail> handleNoSuchElementException(NoSuchElementException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

}
