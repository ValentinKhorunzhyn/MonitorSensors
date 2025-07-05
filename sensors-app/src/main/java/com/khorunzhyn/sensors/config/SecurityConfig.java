package com.khorunzhyn.sensors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/api/sensors", "/api/sensors/*")
                        .hasAnyRole("VIEWER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/sensors/**")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/sensors/**")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/sensors/**")
                        .hasRole("ADMIN")
                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}

