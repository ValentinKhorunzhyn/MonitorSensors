package com.khorunzhyn.sensors.repository;

import com.khorunzhyn.sensors.model.SensorUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorUnitRepository extends JpaRepository<SensorUnit, Long> {

    Optional<SensorUnit> findByUnitName(String unitName);

}
