package com.khorunzhyn.statistics.client;

import com.khorunzhyn.statistics.dto.SensorDto;
import com.khorunzhyn.statistics.model.sensor.Sensor;

import java.util.List;

public interface ISensorsRestClient {

    List<Sensor> getAllSensors();

}
