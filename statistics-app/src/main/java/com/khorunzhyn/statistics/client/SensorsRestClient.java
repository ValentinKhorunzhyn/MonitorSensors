package com.khorunzhyn.statistics.client;

import com.khorunzhyn.statistics.model.sensor.Sensor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;


public class SensorsRestClient implements ISensorsRestClient {

    private static final ParameterizedTypeReference<List<Sensor>> SENSORS_TYPE_REFERENCE =
            new ParameterizedTypeReference<List<Sensor>>() {
            };
    private final RestClient restClient;

    public SensorsRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<Sensor> getAllSensors() {
        return restClient
                .get()
                .uri("api/sensors")
                .retrieve()
                .body(SENSORS_TYPE_REFERENCE);
    }
}
