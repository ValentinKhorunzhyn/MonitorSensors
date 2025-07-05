package com.khorunzhyn.sensors.repository;

import com.khorunzhyn.sensors.model.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {

    Optional<SensorType> findByTypeName(String typeName);

}
