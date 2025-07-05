package com.khorunzhyn.sensors.repository;

import com.khorunzhyn.sensors.model.AppSensorUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppSensorUser, Integer> {

    Optional<AppSensorUser> findByUserName(String username);

}
