package com.khorunzhyn.statistics.config;

import com.khorunzhyn.statistics.client.SensorsRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {

    @Bean
    public SensorsRestClient sensorsRestClient(
            @Value("${app.services.sensors.url:http://localhost:8080}") String sensorsBaseUrl,
            @Value("${app.services.sensors.username:}") String sensorsUsername,
            @Value("${app.services.sensors.password:}") String sensorsPassword) {
        return new SensorsRestClient(RestClient.builder()
                .baseUrl(sensorsBaseUrl)
                .requestInterceptor(new BasicAuthenticationInterceptor(sensorsUsername, sensorsPassword))
                .build());
    }
}
